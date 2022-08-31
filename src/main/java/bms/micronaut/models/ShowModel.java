package bms.micronaut.models;

import lombok.Data;

import java.time.LocalDateTime;

@Data

public class ShowModel {


    private int id;

    private LocalDateTime start_time;
    private LocalDateTime end_time;


    private MovieModel movie;

    private ShowModel show;


}
