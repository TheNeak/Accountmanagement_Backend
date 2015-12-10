package se1app.applicationcore.reservationcomponent;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import se1app.applicationcore.Application;
import se1app.applicationcore.customercomponent.Customer;
import se1app.applicationcore.customercomponent.CustomerRepository;
import se1app.applicationcore.reservationcomponent.Reservation;
import se1app.applicationcore.reservationcomponent.ReservationRepository;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(classes = Application.class)
public class ReservationRepositoryTest {

    @Autowired
    private ReservationRepository reservationRepository;
    @Autowired
    private CustomerRepository customerRepository;

    @Before
    public void setup() {
        Customer stefan = new Customer("Stefan");
        Reservation reservation = new Reservation("Spectre");
        stefan.addReservation(reservation);
        reservation.setCustomer(stefan);
        customerRepository.save(stefan);

        Customer ina = new Customer("Ina");
        reservation = new Reservation("Spectre");
        ina.addReservation(reservation);
        reservation.setCustomer(ina);
        customerRepository.save(ina);
    }

    @Test
    public void testFindReservationsByMovie(){
        List<Reservation> reservations = reservationRepository.findByMovie("Spectre");
        assertThat(reservations).hasSize(2);
    }

    @Test
    public void testFindReservationsByCustomer(){
        Customer stefan = customerRepository.findByName("Stefan").get();
        List<Reservation> reservations = reservationRepository.findByCustomer(stefan);
        assertThat(reservations).hasSize(1);
        assertThat(reservations).extracting(reservation -> reservation.getMovie())
                .contains("Spectre");
    }
}
