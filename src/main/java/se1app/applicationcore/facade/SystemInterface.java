package se1app.applicationcore.facade;

import se1app.applicationcore.customercomponent.Customer;

import java.util.List;

/**
 * Created by srs on 12.12.15.
 */
public interface SystemInterface {
    List<Customer> getAllCustomers();
    void deleteCustomer(Integer customerId);
    Customer getCustomer(Integer customerId);
    Customer addCustomer(Customer customer);
}
