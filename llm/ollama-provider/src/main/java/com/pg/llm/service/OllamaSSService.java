package com.pg.llm.service;

import com.pg.llm.domain.EmbeddingResponse;
import org.bson.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Map;

@Service
public class OllamaSSService {

    private static final Logger logger = LoggerFactory.getLogger(OllamaSSService.class);

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
    public OllamaSSService(WebClient.Builder webClientBuilder, ReactiveMongoTemplate reactiveMongoTemplate) {
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
                    logger.info("Embedding response: {}", embeddingResponse);
                })
                .map(EmbeddingResponse::getEmbedding);
    }

    // Method to update MongoDB document with the embedding vector
    public Mono<Long> updateDocumentWithEmbedding(String documentId, String plot) {
        return createEmbedding(plot)
                .flatMap(embedding -> {
                    // Create MongoDB query and update operations
                    Query query = new Query(Criteria.where("_id").is(documentId));
                    Update update = new Update().set(mongoIndexField, embedding);

                    // Update the document in MongoDB and return the count of updated documents
                    return reactiveMongoTemplate.updateFirst(query, update, collectionName)
                            .map(updateResult -> updateResult.getModifiedCount());
                });
    }

    // Method to process and update embeddings for multiple documents
    public void updateEmbeddingsForAllDocuments() {
        // Find all documents with a 'plot' field
        Query query = new Query(Criteria.where("plot").exists(true)).limit(50);

        reactiveMongoTemplate.find(query, Document.class, collectionName)
                .flatMap(document -> {
                    String documentId = document.getObjectId("_id").toHexString();
                    String plot = document.getString("plot");

                    // Update each document with embedding
                    return updateDocumentWithEmbedding(documentId, plot);
                })
                .subscribe(updatedCount -> {
                    logger.info("Updated documents: {}", updatedCount);
                }, error -> {
                    logger.error("Error occurred while updating embeddings: {}", error.getMessage());
                });
    }
}
