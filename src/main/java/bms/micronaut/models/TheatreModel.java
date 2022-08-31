package bms.micronaut.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class TheatreModel {


    private int id;



    private String name;

    private int no_of_screens;


    private CityModel city;


}
