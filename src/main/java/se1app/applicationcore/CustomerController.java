package se1app.applicationcore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
class CustomerController {

    @Autowired
    private CustomerRepository repository;

    @RequestMapping("/customers")
    List<Customer> characters() {
        return repository.findAll();
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