package bms.micronaut.services;

import bms.micronaut.DAO.BookingDAO;
import bms.micronaut.DAO.SeatDAO;
import bms.micronaut.DAO.UserDAO;
import bms.micronaut.DTO.SeatDTO;
import bms.micronaut.utils.Base64Decoder;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

import java.sql.SQLException;
import java.util.List;

@Singleton
public class BookingService {

    @Inject
    BookingDAO bookingDAO;

    @Inject
    UserDAO userDAO;
    @Inject
    SeatDAO seatDao;
    public String bookSeat(int seatId, int showId, String header) throws SQLException {

        String mail = getUserEmail(header);
        int user_id = getUserId(mail);
        if(seatAvailable(seatId, showId)){
            bookingDAO.bookSeat(seatId, showId, user_id);
            return bookingStatus(seatId, true);
        }
        else
            return bookingStatus(seatId, false);
    }

    private int getUserId(String email) throws SQLException {
        return userDAO.getUserId(email);
    }

    private String getUserEmail(String header) {
        String headerContent = header.split(" ")[1];

        String decodedHeader = Base64Decoder.decode(headerContent);
        String[] userPass=decodedHeader.split(":");
        return  userPass[0];
    }

    private String bookingStatus(int seatId, boolean flag) {
        if(flag)
            return "Seat successfully booked";
        else
            return "Oops, seat not available";
    }

    private boolean seatAvailable(int seatId, int showId) throws SQLException {
        List<SeatDTO> seatList = seatDao.getAvailableSeats(showId);

        for(SeatDTO seat: seatList)
            if(seat.getId() == seatId)
                return true;

        return false;
    }
}
