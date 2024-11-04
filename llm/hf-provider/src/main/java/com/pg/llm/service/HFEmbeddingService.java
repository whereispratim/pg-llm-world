package com.pg.llm.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.bson.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationOperation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;
import reactor.util.retry.Retry;

import java.time.Duration;
import java.util.List;

@Service
public class HFEmbeddingService {

    private static final Logger logger = LoggerFactory.getLogger(HFEmbeddingService.class);

    @Value("${pg.hugging-face.url}")
    private String huggingFaceUrl;

    @Value("${pg.hugging-face.token}")
    private String token;

    @Value("${pg.mongo.index-field}")
    private String mongoIndexField;

    @Value("${pg.mongo.collection}")
    private String collectionName;

    private final ReactiveMongoTemplate reactiveMongoTemplate;

    @Autowired
    public HFEmbeddingService(ReactiveMongoTemplate reactiveMongoTemplate) {
        this.reactiveMongoTemplate = reactiveMongoTemplate;
    }

    @Autowired
    private ObjectMapper objectMapper;

    // Method to generate embedding
    public List<Double> generateEmbedding(String text){
        String responseBody = WebClient.builder().build()
                .post()
                .uri(huggingFaceUrl)
                .header(HttpHeaders.AUTHORIZATION, "Bearer " + token)
                .header(HttpHeaders.CONTENT_TYPE, "application/json")
                .bodyValue("{\"inputs\":\"" + text + "\"}")
                .retrieve()
                .bodyToMono(String.class)
                .retryWhen(Retry.backoff(5, Duration.ofSeconds(10))
                        .maxBackoff(Duration.ofSeconds(30))
                        .filter(throwable -> throwable instanceof WebClientResponseException &&
                                ((WebClientResponseException) throwable).getStatusCode() == HttpStatus.TOO_MANY_REQUESTS))
                .onErrorMap(e -> new RuntimeException("Failed to fetch embeddings", e))
                .block(); // Blocking call to get the response synchronously

        if (responseBody == null) {
            throw new RuntimeException("Response body is null");
        }

        try {
            return objectMapper.readValue(responseBody, new TypeReference<List<Double>>() {});
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateEmbeddings() {
        // Define the query to find documents where the 'plot' field exists
        Query query = new Query();
        query.addCriteria(Criteria.where("plot").exists(true));
        query.limit(50);

        // Find the documents matching the query
        reactiveMongoTemplate.find(query, Document.class, collectionName)
                .flatMap(doc -> {
                    // Wrap the blocking method in a Mono using fromCallable
                    return Mono.fromCallable(() -> generateEmbedding(doc.getString("plot")))
                            .subscribeOn(Schedulers.boundedElastic())  // Run the blocking call on a bounded elastic thread pool
                            .flatMap(embedding -> {
                                // Once embeddings are generated, update the document
                                doc.put(mongoIndexField, embedding);

                                // Replace the document in the collection
                                return reactiveMongoTemplate.save(doc, collectionName);
                            });
                })
                .doOnError(e -> {
                    // Handle any errors that occur during processing
                    logger.error("Error during processing: {}", e.getMessage());
                })
                .subscribe();  // Subscribe to start processing the reactive pipeline
    }

    public Mono<List<Document>> performVectorSearch(String query) {
        // Generate embedding for the query using Hugging Face
        return Mono.fromCallable(() -> generateEmbedding(query))
                .subscribeOn(Schedulers.boundedElastic())
                .flatMap(queryEmbedding -> {
                    // Build the vector search criteria using $vectorSearch aggregation
                    Document vectorSearchQuery = new Document()
                            .append("queryVector", queryEmbedding)
                            .append("path", mongoIndexField)
                            .append("numCandidates", 100)
                            .append("limit", 4)
                            .append("index", "vector_index");

                    AggregationOperation vectorSearch = _ -> new Document("$vectorSearch", vectorSearchQuery);

                    // Use Aggregation with vector search
                    Aggregation aggregation = Aggregation.newAggregation(vectorSearch);

                    // Perform the aggregation query in MongoDB using ReactiveMongoTemplate
                    return reactiveMongoTemplate.aggregate(aggregation, collectionName, Document.class).collectList();
                });
    }

    public Mono<Void> removeFieldFromCollection(String collectionName, String fieldName) {
        // Create an Update object to specify the field to be removed
        Update update = new Update().unset(fieldName);

        // Perform the update operation
        return reactiveMongoTemplate.updateMulti(
                        new Query(), // Query to match all documents
                        update, // Update object specifying the unset operation
                        collectionName // The name of the collection
                )
                .doOnSuccess(result -> logger.debug("Update successful: {}", result.getModifiedCount() + " documents modified"))
                .doOnError(e -> logger.error("Error during update: {}", e.getMessage()))
                .then(); // Return Mono<Void> to indicate completion
    }
}
