package bms.micronaut.DAO;

import bms.micronaut.config.PropertiesConfiguration;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Singleton
public class BookingDAO {

    @Inject
    PropertiesConfiguration propertiesConfiguration;

    private Connection getDBConnection() throws SQLException {
        return DriverManager.getConnection(
                propertiesConfiguration.getConnectionURL(),
                propertiesConfiguration.getUsername(),
                propertiesConfiguration.getPassword()
        );
    }
    public void bookSeat(int user_id,int show_time_id,int seat_id) throws SQLException {
        Connection con=getDBConnection();
        String BOOK_SEAT_WITH_SHOWTIME="Insert into booking (user_id,show_time_id,seat_id) VALUES (?,?,?) ";
        PreparedStatement stmt=con.prepareStatement(BOOK_SEAT_WITH_SHOWTIME);
        stmt.setInt(1,user_id);
        stmt.setInt(2,show_time_id);
        stmt.setInt(3,seat_id);
        stmt.executeUpdate();
        stmt.close();
        con.close();


    }
}



