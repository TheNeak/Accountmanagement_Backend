package se1app.applicationcore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import se1app.applicationcore.customercomponent.Customer;
import se1app.applicationcore.customercomponent.CustomerRepository;
import se1app.applicationcore.reservationcomponent.Reservation;

import java.util.Arrays;

@SpringBootApplication
public class Application {

    @Bean
    CommandLineRunner init(CustomerRepository customerRepository) {
        return (evt) -> Arrays.asList(
                "mueller,meier,schulze".split(","))
                .forEach(
                        a -> {
                            Customer customer = new Customer(a);
                            Reservation reservation = new Reservation("Spectre");
                            customer.addReservation(reservation);
                            reservation.setCustomer(customer);

                            customerRepository.save(customer);
                        });
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
