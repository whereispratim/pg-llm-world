package com.pg.llm.producer;

import com.pg.llm.model.Movie;
import com.pg.llm.service.MovieSSService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import reactor.core.scheduler.Schedulers;

@Component
public class MovieConsumer {

    private static final Logger logger = LoggerFactory.getLogger(MovieConsumer.class);

    @Value("${pg.topic}")
    private String topic;

    private final ReactiveMongoTemplate mongoTemplate;
    private final MovieSSService semanticSearchService;

    public MovieConsumer(ReactiveMongoTemplate mongoTemplate, MovieSSService semanticSearchService) {
        this.mongoTemplate = mongoTemplate;
        this.semanticSearchService = semanticSearchService;
    }

    @KafkaListener(topics = "movies", groupId = "org_group")
    public void consumeCustomerInteraction(Movie movie) {
        // Perform semantic search on the field plot
        semanticSearchService.createEmbedding(movie.getPlot())
                .flatMap(embedding -> {
                    movie.setPlot_embedding_ollama(embedding); // Set the embedding
                    return mongoTemplate.save(movie); // Save the updated movie
                })
                .subscribeOn(Schedulers.boundedElastic()) // Run on a bounded elastic thread pool
                .subscribe(
                        savedMovie -> logger.debug("Saved movie: {}",  savedMovie),
                        error -> logger.error("Error processing movie: {}", error.getMessage())
                );
    }

}

