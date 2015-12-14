package se1app.applicationcore.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import se1app.applicationcore.customercomponent.Customer;
import se1app.applicationcore.customercomponent.CustomerComponentInterface;
import se1app.applicationcore.customercomponent.Reservation;
import se1app.applicationcore.moviecomponent.MovieComponentInterface;

import java.util.List;

@RestController
class ApplicationFacadeController {

    @Autowired
    private CustomerComponentInterface customerComponentInterface;

    @Autowired
    private MovieComponentInterface movieComponentInterface;

    @RequestMapping("/customers")
    public List<Customer> getAllCustomers()
    {
        return customerComponentInterface.getAllCustomers();
    }

    @RequestMapping(value = "/customers/{id}", method = RequestMethod.GET)
    public Customer getCustomer(@PathVariable("id") Integer id) {
        return customerComponentInterface.getCustomer(id);
    }

    @RequestMapping(value = "/customers/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCustomer(@PathVariable("id") Integer id) {
        customerComponentInterface.deleteCustomer(id);
    }

    @RequestMapping(value = "/customers", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Customer addCustomer(@RequestBody Customer customer) {
        customerComponentInterface.addCustomer(customer);
        return customer;
    }

    @RequestMapping(value = "/customers/{id}/reservations", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void addReservation(@PathVariable("id") Integer customerId, @RequestBody Reservation reservation) {
        customerComponentInterface.addReservation(customerId, reservation);
    }

    @RequestMapping(value = "/movies/{title}", method = RequestMethod.GET)
    public Integer getNumberOfReservations(@PathVariable("title") String title) {
        return movieComponentInterface.getNumberOfReservations(title);
    }
}