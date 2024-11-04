package com.pg.llm.service;

import com.pg.llm.model.Movie;
import com.pg.llm.repository.MovieRepository;
import org.bson.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationOperation;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class MovieService {

    private static final Logger logger = LoggerFactory.getLogger(MovieService.class);

    @Value("${pg.mongo.index-field}")
    private String mongoIndexField;

    @Value("${pg.mongo.collection}")
    private String collectionName;

    @Autowired
    private ReactiveMongoTemplate reactiveMongoTemplate;
    private final OllamaSSService embeddingService;

    private final MovieRepository movieRepository;

    @Autowired
    public MovieService(MovieRepository movieRepository, OllamaSSService embedder) {
        this.movieRepository = movieRepository;
        this.embeddingService = embedder;
    }


    public Mono<List<Movie>> getMoviesSemanticSearch(String plotDescription) {
        return embeddingService.createEmbedding(plotDescription)
                .flatMapMany(movieRepository::findMoviesByVector)
                .collectList();
    }

    public Mono<List<Movie>> performVectorSearch(String query) {
        return embeddingService.createEmbedding(query)
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
                            .onErrorResume(_ -> Mono.empty()); // Handle errors gracefully
                });
    }

    private void logAggregation(Aggregation aggregation) {
        // Get the aggregation pipeline for logging
        List<Document> pipeline = aggregation.toPipeline(Aggregation.DEFAULT_CONTEXT);
        logger.debug("Aggregation Pipeline: {}", pipeline);
    }
}