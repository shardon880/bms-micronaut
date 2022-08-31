package bms.micronaut.DAO;

import bms.micronaut.DTO.SeatDTO;
import bms.micronaut.config.PropertiesConfiguration;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Singleton
public class SeatDAO {

    @Inject
    PropertiesConfiguration propertiesConfiguration;

    private Connection getDBConnection() throws SQLException {
        return DriverManager.getConnection(
                propertiesConfiguration.getConnectionURL(),
                propertiesConfiguration.getUsername(),
                propertiesConfiguration.getPassword()
        );
    }
    public List<SeatDTO> getAvailableSeats(int showId) throws SQLException {

        Connection con = getDBConnection();

        String FETCH_SEATS = "Select s.id,s.seat_no from seat as s INNER JOIN screen as cs on s.screen_id =c s.id INNER JOIN show_time as st on st.screen_id=cs.id WHERE st.id=? "
                +
                "and s.id NOT IN (Select s.id from seat as s INNER JOIN booking as b on b.seat_id=s.id where b.show_time_id=?)";

        PreparedStatement stmt = con.prepareStatement(FETCH_SEATS);
        stmt.setInt(1,showId);
        stmt.setInt(2,showId);

        ResultSet rst = stmt.executeQuery();
        List<SeatDTO> availableSeats = new ArrayList<>();
        while (rst.next()){
            SeatDTO seat = new SeatDTO();
            seat.setId(rst.getInt("id"));
            seat.setSeat_no(rst.getString("seat_no"));

            availableSeats.add(seat);
        }
        return new ArrayList<>();
    }
}
