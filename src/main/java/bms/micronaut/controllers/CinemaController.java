package bms.micronaut.controllers;

import bms.micronaut.services.CinemaService;
import io.micronaut.http.annotation.Controller;
import io.micronaut.security.annotation.Secured;
import io.micronaut.security.rules.SecurityRule;
import jakarta.inject.Inject;

import java.util.List;

@Secured(SecurityRule.IS_ANONYMOUS)
@Controller("/v1/movie")
public class CinemaController {

    @Inject
    CinemaService cinemaService;

    public List<String> getCinema(int movie_id) throws Exception{
        return cinemaService.getCinemaByMovie(movie_id);
    }
}
