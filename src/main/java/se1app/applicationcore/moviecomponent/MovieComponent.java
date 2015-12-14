package se1app.applicationcore.moviecomponent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import se1app.applicationcore.customercomponent.Customer;
import se1app.applicationcore.customercomponent.CustomerRepository;
import se1app.applicationcore.customercomponent.Reservation;

import java.util.List;

@Component
public class MovieComponent implements MovieComponentInterface {

    private MovieRepository movieRepository;

    @Autowired
    public MovieComponent(MovieRepository movieRepository)
    {
        this.movieRepository = movieRepository;
    }

    @Override
    public Integer getNumberOfReservations(String movieTitle) {
        Movie movie = movieRepository.findByTitle(movieTitle);
        return movie.getNumberOfReservations();
    }

    @Override
    public void increaseReservationStatistics(String movieTitle) {
        Movie movie = movieRepository.findByTitle(movieTitle);
        movie.increaseReservationStatistics();
        movieRepository.save(movie);
    }
}
