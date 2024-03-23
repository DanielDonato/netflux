package dev.ddonato.netflux.service;

import dev.ddonato.netflux.domain.Movie;
import dev.ddonato.netflux.domain.MovieEvent;
import dev.ddonato.netflux.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;

    @Override
    public Mono<Movie> findById(String id) {
        return movieRepository.findById(id);
    }

    @Override
    public Flux<Movie> findAll() {
        return movieRepository.findAll();
    }

    @Override
    public Flux<MovieEvent> streamEvents(String id) {
        return Flux.<MovieEvent>generate((movieEventSynchronousSink) -> {
            movieEventSynchronousSink.next(new MovieEvent(id, LocalDateTime.now()));
        }).delayElements(Duration.ofSeconds(1));
    }
}
