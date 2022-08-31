package bms.micronaut.DAO;

import bms.micronaut.config.PropertiesConfiguration;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Singleton
public class MovieDao {

    @Inject
    PropertiesConfiguration propertiesConfiguration;

    private Connection getDBConnection() throws SQLException{
        return DriverManager.getConnection(
                propertiesConfiguration.getConnectionURL(),
                propertiesConfiguration.getUsername(),
                propertiesConfiguration.getPassword()
        );
    }
    public List<HashMap> getMoviesInCity(int id) throws SQLException {
        Connection con = getDBConnection();
        String FETCH_MOVIES = "Select m.id, m.movie_name, m.description, m.release_date from movie m inner join movie_city mc on m.id=mc.movie_id where mc.city_id=?";
        PreparedStatement stmt = con.prepareStatement(FETCH_MOVIES);

        stmt.setInt(1, id);
        ResultSet rst = stmt.executeQuery();

        List<HashMap> list = new ArrayList<>();
        while(rst.next()){
            HashMap<String,String> map = new HashMap<>();
            map.put("Name", rst.getString(2) );
            map.put("Description", rst.getString(3));
            map.put("Release Date", rst.getString(4));
            list.add(map);
        }
        stmt.close();
        con.close();
        return list;
    }
}
