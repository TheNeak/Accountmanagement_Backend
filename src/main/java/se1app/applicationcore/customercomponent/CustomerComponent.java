package se1app.applicationcore.customercomponent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import se1app.applicationcore.moviecomponent.MovieComponentInterface;
import se1app.applicationcore.moviecomponent.MovieRepository;

import java.util.List;
import java.util.Optional;

@Component
public class CustomerComponent implements CustomerComponentInterface {

    private CustomerRepository customerRepository;

    private MovieComponentInterface movieComponentInterface;

    @Autowired
    public CustomerComponent(CustomerRepository customerRepository, MovieComponentInterface movieComponentInterface)
    {
        this.customerRepository = customerRepository;
        this.movieComponentInterface = movieComponentInterface;
    }

    @Override
    public List<Customer> getAllCustomers()
    {
        return customerRepository.findAll();
    }

    @Override
    public void deleteCustomer(Integer customerId)
    {
        customerRepository.delete(customerId);
    }

    @Override
    public Customer getCustomer(Integer customerId)
    {
        return customerRepository.findOne(customerId);
    }

    @Override
    public void addCustomer(Customer customer)
    {
        customerRepository.save(customer);
    }

    @Override
    public void addReservation(Integer customerId, Reservation reservationToAdd) {
        Customer customer = customerRepository.findOne(customerId);
        customer.addReservation(reservationToAdd);
        customerRepository.save(customer);

        movieComponentInterface.increaseReservationStatistics(reservationToAdd.getMovie().getTitle());
    }
}
