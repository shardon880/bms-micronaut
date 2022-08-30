package bms.micronaut.controllers;

import bms.micronaut.services.MovieService;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.security.annotation.Secured;
import io.micronaut.security.rules.SecurityRule;
import jakarta.inject.Inject;

import java.util.List;

@Secured(SecurityRule.IS_ANONYMOUS)
@Controller("/v1/city")
public class MovieController {

    @Inject
    MovieService movieService;

    @Get("/{cityId}")
    public List<String> moviesInCity(int cityId) throws Exception {

        System.out.println("gottcha");

     return movieService.getMovieFromCity(cityId);
    }
}
