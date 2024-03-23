package dev.ddonato.netflux.service;

import dev.ddonato.netflux.domain.Movie;
import dev.ddonato.netflux.domain.MovieEvent;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface MovieService {

    Mono<Movie> findById(String id);

    Flux<Movie> findAll();

    Flux<MovieEvent> streamEvents(String id);
}
