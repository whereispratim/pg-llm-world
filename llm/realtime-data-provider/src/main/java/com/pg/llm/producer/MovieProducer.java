package com.pg.llm.producer;

import com.pg.llm.model.Movie;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.reactive.ReactiveKafkaProducerTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.Random;
import java.util.UUID;

@Component
public class MovieProducer {

    private static final Logger logger = LoggerFactory.getLogger(MovieProducer.class);


    @Value("${pg.topic}")
    private String topic;


    private final ReactiveKafkaProducerTemplate<String, Movie> kafkaTemplate;

    public MovieProducer(ReactiveKafkaProducerTemplate<String, Movie> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public Mono<Void> generateAndSend() {
        return Flux.interval(Duration.ofMillis(1))
                .map(i -> generateRandomInteraction()) // Generate a random interaction
                .flatMap(movie -> kafkaTemplate
                        .send((ProducerRecord<String, Movie>) MessageBuilder
                        .withPayload(movie)
                        .setHeader(KafkaHeaders.TOPIC, topic)
                        .setHeader(KafkaHeaders.KEY, movie.getId())
                        .build()))
                .doOnNext(result -> logger.debug("Sent: {}", result.recordMetadata().topic()))
                .then();
    }

    private Movie generateRandomInteraction() {
        Movie movie = new Movie();
        // Generating unique ID
        movie.setId(UUID.randomUUID());
        movie.setPlot(getPlot());
        //Generate and set values for all fields
        //
        return movie;
    }


    // Generate a random movie-related plot
    public static String getPlot() {
        String[] summaries = {
                "In a dystopian future, a group of rebels fight against a totalitarian regime, discovering hidden truths about their society along the way.",
                "A young woman discovers she has the ability to communicate with animals, leading her on an adventure to save a threatened species.",
                "After inheriting an old mansion, a family uncovers dark secrets hidden within its walls, revealing a history of betrayal and vengeance.",
                "In a small town, a mysterious stranger arrives, sparking a series of events that change the lives of the residents forever.",
                "A gifted musician struggles with the pressures of fame and must rediscover their passion for music while navigating personal relationships.",
                "During a summer vacation, a group of friends stumbles upon a treasure map, leading them on a thrilling quest filled with danger and excitement.",
                "Set in the 1980s, a group of kids bands together to solve supernatural mysteries in their neighborhood, discovering the power of friendship."
        };

        // Generate a random index to select a summary
        Random random = new Random();
        int index = random.nextInt(summaries.length);
        return summaries[index];
    }


}

