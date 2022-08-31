package bms.micronaut.services;

import bms.micronaut.DAO.MovieDAO;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

import java.util.HashMap;
import java.util.List;

@Singleton
public class MovieService {

    @Inject
    MovieDAO movieDao;

    public List<HashMap> getMovieFromCity(int id) throws Exception {
        return movieDao.getMoviesInCity(id);
    }
}
