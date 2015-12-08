package se1app.applicationcore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CustomerUseCases {

    @Autowired
    private CustomerRepository customerRepository;

    public void doSomething()
    {
        Customer customer = new Customer("Stefan");
        customerRepository.save(customer);
    }
}
