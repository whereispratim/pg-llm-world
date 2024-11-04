package com.pg.llm.controller;
import com.pg.llm.service.HFEmbeddingService;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
public class EmbeddingController {

    @Value("${pg.mongo.collection}")
    private String collectionName;

    @Value("${pg.mongo.index-field}")
    private String mongoIndexField;

    private final HFEmbeddingService embeddingService;

    public EmbeddingController(HFEmbeddingService embeddingService) {
        this.embeddingService = embeddingService;
    }

    @GetMapping("/generate-embedding")
    public List<Double> generateEmbedding(@RequestParam String text) {
        return embeddingService.generateEmbedding(text);
    }

    @Scheduled
    @PostMapping("/update-embedding")
    public void updateEmbeddings() {
        //it is calling generateEmbedding with field "plot"
        embeddingService.updateEmbeddings();
    }

    @PostMapping("/movies/semantic-search")
    public Mono<ResponseEntity<List<Document>>> vectorSearch(@RequestParam String query) {
        return embeddingService.performVectorSearch(query)
                .map(ResponseEntity::ok)
                .onErrorReturn(ResponseEntity.status(500).build());
    }

    @PostMapping("/drop-field")
    public void removeFieldFromCollection() {
        embeddingService.removeFieldFromCollection(collectionName, mongoIndexField);
    }

}
