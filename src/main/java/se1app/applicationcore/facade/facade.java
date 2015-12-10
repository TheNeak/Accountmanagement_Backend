package se1app.applicationcore.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import se1app.applicationcore.customercomponent.Customer;
import se1app.applicationcore.customercomponent.CustomerRepository;
import se1app.applicationcore.customercomponent.CustomerUseCases;

import java.util.List;

@RestController
class Facade {

    @Autowired
    private CustomerRepository repository;

    @Autowired
    private CustomerUseCases customerUseCases;

    @RequestMapping("/customers")
    List<Customer> getAllCustomers()
    {
        return customerUseCases.getAllCustomers();
    }

    @RequestMapping(value = "/customers/{id}", method = RequestMethod.GET)
    Customer get(@PathVariable("id") Integer id) {
        return repository.findOne(id);
    }

    @RequestMapping(value = "/customers/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void delete(@PathVariable("id") Integer id) {
        repository.delete(id);
    }

    @RequestMapping(value = "/customers", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    Customer save(@RequestBody Customer customer) {
        //Customer customer = new Customer(customerDTO.getName());
        repository.save(customer);
        return customer;
    }
}