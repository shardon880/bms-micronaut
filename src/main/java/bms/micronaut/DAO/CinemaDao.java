package bms.micronaut.DAO;

import bms.micronaut.config.PropertiesConfiguration;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Singleton
public class CinemaDao {

    @Inject
    PropertiesConfiguration propertiesConfiguration;

    private Connection getDBConnection() throws SQLException{
        return DriverManager.getConnection(
                propertiesConfiguration.getConnectionURL(),
                propertiesConfiguration.getUsername(),
                propertiesConfiguration.getPassword()
        );
    }
    public List<String> getCinemaBYMovie(int movie_id) throws SQLException {

        Connection con = getDBConnection();
        String FETCH_CINEMA = "SELECT";

        PreparedStatement stmt = con.prepareStatement(FETCH_CINEMA);
        stmt.setInt(1,movie_id);
        ResultSet rst = stmt.executeQuery();

        return new ArrayList<>();
    }
}
