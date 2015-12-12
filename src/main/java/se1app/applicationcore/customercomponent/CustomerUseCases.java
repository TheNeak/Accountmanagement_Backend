package se1app.applicationcore.customercomponent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CustomerUseCases implements CustomerComponentInterface {

    private CustomerRepository customerRepository;

    @Autowired
    public CustomerUseCases(CustomerRepository customerRepository)
    {
        this.customerRepository = customerRepository;
    }

    public List<Customer> getAllCustomers()
    {
        return customerRepository.findAll();
    }

    public void deleteCustomer(int customerId)
    {
        customerRepository.delete(customerId);
    }

    public Customer getCustomer(int customerId)
    {
        return customerRepository.findOne(customerId);
    }

    public void addCustomer(Customer customer)
    {
        customerRepository.save(customer);
    }
}
