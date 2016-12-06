package se1app.applicationcore.customer_component;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import se1app.applicationcore.movie_component.Movie;

import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Integer> {
    // Spring leitet die Query aus der Signatur ab
    List<Reservation> findByMovie(Movie movie);

    // Spring leitet die Query aus der Signatur ab; hier übergreifend mit referenzierter Entität 'Customer'
    List<Reservation> findByCustomer(Customer customer);
}