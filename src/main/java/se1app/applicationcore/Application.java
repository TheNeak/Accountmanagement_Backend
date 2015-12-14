package se1app.applicationcore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import se1app.applicationcore.customercomponent.Customer;
import se1app.applicationcore.customercomponent.CustomerRepository;
import se1app.applicationcore.customercomponent.Reservation;
import se1app.applicationcore.moviecomponent.Movie;
import se1app.applicationcore.moviecomponent.MovieRepository;

import java.util.Arrays;

@SpringBootApplication // das Folgende in dieser Zeile hinzufügen, um die Authentifizierung zu deaktivieren: (exclude = {SecurityAutoConfiguration.class, ManagementWebSecurityAutoConfiguration.class})
public class Application {

    @Bean
    CommandLineRunner init(CustomerRepository customerRepository) {
        return args -> {
            Customer mickey = new Customer("Mickey Mouse");
            Customer minnie = new Customer("Minnie Mouse");
            Customer pluto = new Customer("Pluto");
            Movie movie007 = new Movie("007");

            Reservation reservation = new Reservation(movie007);
            pluto.addReservation(reservation);

            reservation = new Reservation(movie007);
            minnie.addReservation(reservation);
            reservation.setCustomer(minnie);

            customerRepository.save(Arrays.asList(mickey, minnie, pluto));
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
