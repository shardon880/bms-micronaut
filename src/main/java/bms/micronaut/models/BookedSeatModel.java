package bms.micronaut.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookedSeatModel {

    private int id;


    private BookingModel booking;


    private SeatModel seat;

    private ShowModel show;
}
