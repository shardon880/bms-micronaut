package bms.micronaut.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.Date;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class BookingModel {


    private long id;

    @NotNull
    private Date date;

    @NotNull
    private int number_of_seats_booked;

    @NotNull
    private UserModel user;


    private ShowModel show;




}
