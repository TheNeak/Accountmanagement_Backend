package se1app.applicationcore.moviecomponent;

import se1app.applicationcore.customercomponent.Customer;
import se1app.applicationcore.customercomponent.Reservation;

import java.util.List;

/**
 * Created by srs on 12.12.15.
 */
public interface MovieComponentInterface {

    Integer getNumberOfReservations(String movieTitle);
    void increaseReservationStatistics(String movieTitle);
}
