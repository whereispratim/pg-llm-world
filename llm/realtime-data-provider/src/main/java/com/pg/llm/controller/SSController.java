package com.pg.llm.controller;
import com.pg.llm.model.Movie;

import com.pg.llm.producer.MovieProducer;
import com.pg.llm.service.MovieSSService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
public class SSController {

    @Autowired
    private MovieProducer producer;

    @Autowired
    private MovieSSService semanticSearchService;

    @PostMapping("/send")
    public void send() {
        producer.generateAndSend();
    }

    @GetMapping("/movies/semantic-search")
    public Mono<List<Movie>> performSemanticSearch(@RequestParam("plotDescription") String plotDescription) {
        return semanticSearchService.performVectorSearch(plotDescription);
    }
}
