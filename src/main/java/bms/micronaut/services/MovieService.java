package bms.micronaut.services;

import bms.micronaut.DAO.MovieDao;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

import java.util.List;

@Singleton
public class MovieService {

    @Inject
    MovieDao movieDao;

    public List<String> getMovieFromCity(int id) throws Exception {
        return movieDao.getMoviesInCity(id);
    }
}
