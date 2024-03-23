package dev.ddonato.netflux.repository;

import dev.ddonato.netflux.domain.Movie;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface MovieRepository extends ReactiveMongoRepository<Movie, String> {
}
