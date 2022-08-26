package bms.micronaut.models;

import io.micronaut.data.annotation.GeneratedValue;
import io.micronaut.data.annotation.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShowModel {

    @Id
    @GeneratedValue
    private int id;

    private LocalDateTime start_time;
    private LocalDateTime end_time;


    private MovieModel movie;

    private ShowModel show;


}
