package com.pg.llm.repository;

import com.pg.llm.model.Movie;
import reactor.core.publisher.Flux;

import java.util.List;

public interface MovieRepository {
    Flux<Movie> findMoviesByVector(List<Double> embedding);
}
