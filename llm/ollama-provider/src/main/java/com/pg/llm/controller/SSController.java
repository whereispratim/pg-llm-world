package com.pg.llm.controller;
import com.pg.llm.model.Movie;
import com.pg.llm.service.MovieService;
import com.pg.llm.service.OllamaSSService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
public class SSController {

    @Autowired
    private MovieService movieService;

    @Autowired
    private OllamaSSService semanticSearchService;

    @GetMapping("/create-embedding")
    public void createEmbeddings(@RequestParam String text) {
        semanticSearchService.createEmbedding(text);
    }

    // Run the job every day at 10:30 AM
    @Scheduled(cron = "0 30 10 * * ?")
    @PostMapping("/update")
    public void updateEmbeddingsForAllDocuments() {
        semanticSearchService.updateEmbeddingsForAllDocuments();
    }

    @GetMapping("/movies/semantic-search")
    public Mono<List<Movie>> performSemanticSearch(@RequestParam("plotDescription") String plotDescription) {
        return movieService.getMoviesSemanticSearch(plotDescription);
    }
}
