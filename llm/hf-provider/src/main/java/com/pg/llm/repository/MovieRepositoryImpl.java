package com.pg.llm.repository;

import com.mongodb.reactivestreams.client.MongoCollection;
import com.mongodb.reactivestreams.client.MongoDatabase;
import com.pg.llm.model.Movie;
import org.bson.conversions.Bson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

import java.util.List;

import static com.mongodb.client.model.Aggregates.vectorSearch;
import static com.mongodb.client.model.search.SearchPath.fieldPath;
import static java.util.Arrays.asList;

@Repository
public class MovieRepositoryImpl implements MovieRepository {

    private static final Logger logger = LoggerFactory.getLogger(MovieRepositoryImpl.class);

    @Value("${pg.mongo.index-field}")
    private String mongoIndexField;

    @Autowired
    private ReactiveMongoTemplate reactiveMongoTemplate;

    private final MongoDatabase mongoDatabase;

    public MovieRepositoryImpl(MongoDatabase mongoDatabase) {
        this.mongoDatabase = mongoDatabase;
    }

    private MongoCollection<Movie> getMovieCollection() {
        return mongoDatabase.getCollection("movies", Movie.class);
    }

    @Override
    public Flux<Movie> findMoviesByVector(List<Double> embedding) {
        String indexName = "vector_index";
        int numCandidates = 100;
        int limit = 5;

        logger.debug("Embedding vector size: {}", embedding.size());

        List<Bson> pipeline = asList(
                vectorSearch(
                        fieldPath(mongoIndexField),
                        embedding,
                        indexName,
                        numCandidates,
                        limit));

        return Flux.from(getMovieCollection().aggregate(pipeline, Movie.class))
                .doOnNext(movie -> logger.debug("Movie found: {}", movie.getTitle()))
                .doOnError(e -> {
                    // Log the error stack trace
                    logger.error("Error during aggregation: {}", e.getMessage());
                })
                .onErrorResume(e -> {
                    // Log the error and return an empty Flux or handle it as needed
                    logger.error("Error during aggregation: {}", e.getMessage());
                    return Flux.empty();
                });
    }

}