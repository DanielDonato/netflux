package dev.ddonato.netflux.bootstrap;

import dev.ddonato.netflux.domain.Movie;
import dev.ddonato.netflux.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

@Component
@RequiredArgsConstructor
public class InitMovies implements CommandLineRunner {

    private final MovieRepository movieRepository;


    @Override
    public void run(String... args) throws Exception {
        movieRepository.deleteAll()
                .thenMany(
                        Flux.just("abc123", "Hello World", "Hello, what is your name ?")
                                .map(title -> Movie.builder().title(title).build())
                                .flatMap(movieRepository::save)
                ).doOnComplete(() -> {
                    movieRepository.findAll().subscribe(System.out::println);
                }).subscribe();
    }
}
