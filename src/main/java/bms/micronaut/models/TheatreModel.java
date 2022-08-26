package bms.micronaut.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.micronaut.data.annotation.GeneratedValue;
import io.micronaut.data.annotation.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.HashSet;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class TheatreModel {

    @Id
    @GeneratedValue
    private int id;

    @NotNull

    private String name;

    private int no_of_screens;


    private CityModel city;

    @JsonIgnore
    private HashSet<ScreenModel> screen = new HashSet<>();

}
