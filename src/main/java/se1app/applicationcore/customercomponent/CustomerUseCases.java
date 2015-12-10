package se1app.applicationcore.customercomponent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CustomerUseCases {

    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> getAllCustomers()
    {
        return customerRepository.findAll();
    }

    public void doSomething()
    {
        Customer customer = new Customer("Stefan");
        customerRepository.save(customer);
    }
}
