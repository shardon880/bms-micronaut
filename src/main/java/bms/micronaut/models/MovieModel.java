package bms.micronaut.models;

import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;


public class MovieModel {

    private int id;

    private String movie_name;

    @NotNull
    private int duration;
    private String language;

    private Set<ShowModel> show = new HashSet<>();


}
