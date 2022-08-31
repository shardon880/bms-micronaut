package bms.micronaut.services;

import bms.micronaut.DAO.CinemaDao;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

import java.util.HashMap;
import java.util.List;

@Singleton
public class CinemaService {

    @Inject
    CinemaDao cinemaDao;
    public List<HashMap> getCinemaByMovie(int movie_id) throws Exception{
        return cinemaDao.getCinemaBYMovie(movie_id);
    }
}
