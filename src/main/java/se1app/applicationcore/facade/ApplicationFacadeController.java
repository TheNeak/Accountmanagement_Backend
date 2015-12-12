package se1app.applicationcore.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import se1app.applicationcore.customercomponent.Customer;
import se1app.applicationcore.customercomponent.CustomerComponentInterface;

import java.util.List;

@RestController
class ApplicationFacadeController implements SystemInterface {

    @Autowired
    private CustomerComponentInterface customerComponentInterface;

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
}