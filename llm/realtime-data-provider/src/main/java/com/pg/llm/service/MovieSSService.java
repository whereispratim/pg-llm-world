package com.pg.llm.service;

import com.pg.llm.domain.EmbeddingResponse;
import com.pg.llm.model.Movie;
import org.bson.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationOperation;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Map;

@Service
public class MovieSSService {

    private static final Logger logger = LoggerFactory.getLogger(MovieSSService.class);

    @Value("${spring.ai.ollama.base-url}")
    private String ollamaBaseURL;

    @Value("${pg.ollama.model}")
    private String model;

    @Value("${pg.mongo.index-field}")
    private String mongoIndexField;

    @Value("${pg.mongo.collection}")
    private String collectionName;

    private final WebClient webClient;
    private final ReactiveMongoTemplate reactiveMongoTemplate;

    @Autowired
    public MovieSSService(WebClient.Builder webClientBuilder, ReactiveMongoTemplate reactiveMongoTemplate) {
        this.webClient = webClientBuilder.baseUrl(ollamaBaseURL).build();
        this.reactiveMongoTemplate = reactiveMongoTemplate;
    }

    // Method to create embeddings for text using Ollama API
    public Mono<List<Double>> createEmbedding(String prompt) {
        Map<String, String> requestBody = Map.of(
                "model", model,
                "prompt", prompt
        );

        return webClient.post()
                .uri("/api/embeddings")
                .bodyValue(requestBody)
                .retrieve()
                .bodyToMono(EmbeddingResponse.class)
                .doOnNext(embeddingResponse -> {
                    logger.debug("Embedding response: {}", embeddingResponse);
                })
                .map(EmbeddingResponse::getEmbedding);
    }

    public Mono<List<Movie>> performVectorSearch(String query) {
        return createEmbedding(query)
                .doOnNext(queryEmbedding -> {
                    if (queryEmbedding == null || queryEmbedding.isEmpty()) {
                        logger.error("Error: Generated embedding is null or empty.");
                    } else {
                        logger.debug("Generated embedding: {}", queryEmbedding);
                    }
                })
                .flatMap(queryEmbedding -> {
                    Document vectorSearchQuery = new Document()
                            .append("queryVector", queryEmbedding)
                            .append("path", mongoIndexField)
                            .append("numCandidates", 100)
                            .append("limit", 4)
                            .append("index", "vector_index");

                    AggregationOperation vectorSearch = context -> new Document("$vectorSearch", vectorSearchQuery);
                    Aggregation aggregation = Aggregation.newAggregation(vectorSearch);

                    return reactiveMongoTemplate.aggregate(aggregation, collectionName, Movie.class)
                            .collectList()
                            .doOnNext(movie -> logger.debug("Movie found: {}", movie.getFirst()))
                            .doOnError(e -> {
                                // Log the error stack trace
                                logger.error("Error during aggregation: {}", e.getMessage());
                            })
                            .onErrorResume(e -> Mono.empty()); // Handle errors gracefully
                });
    }
}
