package dev.ddonato.netflux.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class MovieEvent {

    private String id;
    private LocalDateTime date;

}
