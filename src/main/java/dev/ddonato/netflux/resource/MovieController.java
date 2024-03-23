package dev.ddonato.netflux.resource;

import dev.ddonato.netflux.domain.Movie;
import dev.ddonato.netflux.domain.MovieEvent;
import dev.ddonato.netflux.repository.MovieRepository;
import dev.ddonato.netflux.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping("/movies")
public class MovieController {

    private final MovieService movieService;

    @GetMapping("/{id}")
    public Mono<Movie> findById(@PathVariable String id) {
        return movieService.findById(id);
    }

    @GetMapping()
    public Flux<Movie> findAll() {
        return movieService.findAll();
    }

    @GetMapping(value = "/{id}/events", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<MovieEvent> streamEvents(@PathVariable String id) {
        return movieService.streamEvents(id);
    }
}
