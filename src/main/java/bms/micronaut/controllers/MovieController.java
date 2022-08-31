package bms.micronaut.controllers;

import bms.micronaut.services.MovieService;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.security.annotation.Secured;
import io.micronaut.security.rules.SecurityRule;
import jakarta.inject.Inject;

import java.util.HashMap;
import java.util.List;

@Secured(SecurityRule.IS_ANONYMOUS)
@Controller("/v1/city")
public class MovieController {

    @Inject
    MovieService movieService;

    @Get("/{cityId}")
    public List<HashMap> moviesInCity(int cityId) throws Exception {
     return movieService.getMovieFromCity(cityId);
    }
}
