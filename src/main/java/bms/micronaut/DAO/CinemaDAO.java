package bms.micronaut.DAO;

import bms.micronaut.config.PropertiesConfiguration;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Singleton
public class CinemaDAO {

    @Inject
    PropertiesConfiguration propertiesConfiguration;

    private Connection getDBConnection() throws SQLException{
        return DriverManager.getConnection(
                propertiesConfiguration.getConnectionURL(),
                propertiesConfiguration.getUsername(),
                propertiesConfiguration.getPassword()
        );
    }
    public List<HashMap> getCinemaBYMovie(int movie_id) throws SQLException {

        Connection con = getDBConnection();
        String FETCH_CINEMA =  "Select s.id as show_time_id, s.start_time, s.end_time, " +
                "m.movie_name as movie_name, c.name as cinema_name, c.id as cinema_id " +
                "From show_time as s " +
                "INNER JOIN movie as m ON m.id = s.movie_id " +
                "INNER JOIN screen as sc ON s.screen_id = sc.id " +
                "INNER JOIN cinema as c ON sc.cinema_id = c.id " +
                "WHERE s.movie_id = ?";


        PreparedStatement stmt = con.prepareStatement(FETCH_CINEMA);
        stmt.setInt(1,movie_id);
        ResultSet rst = stmt.executeQuery();
        List<HashMap> list = new ArrayList<>();

        while (rst.next()){
            HashMap<String, String>  map= new HashMap<>();
            map.put("Cinema Name", rst.getString("cinema_name"));
            map.put("Movie Name", rst.getString("movie_name"));
            map.put("Start Time", rst.getString("start_time"));
            map.put("End Time", rst.getString("end_time"));
            map.put("Show id", String.valueOf(rst.getInt("show_time_id")));
            list.add(map);
        }

        System.out.println("Hello  Buddy");
        return list;
    }
}
