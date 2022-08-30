package bms.micronaut.controllers;

import bms.micronaut.services.BookingService;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Header;
import io.micronaut.security.annotation.Secured;
import io.micronaut.security.rules.SecurityRule;
import jakarta.inject.Inject;

@Secured(SecurityRule.IS_AUTHENTICATED)
@Controller("/v1/booking")
public class BookingController {

    @Inject
    BookingService bookingService;

    @Get("/v1/{showId}/seats/{seatId}")
    public String bookSeat(int seatId, int showId, @Header("Authorization") String authHeader) throws Exception{
        return bookingService.bookSeat(seatId, showId, authHeader);
    }
}
