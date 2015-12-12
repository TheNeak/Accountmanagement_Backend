package se1app.applicationcore.customercomponent;

import java.util.List;

/**
 * Created by srs on 12.12.15.
 */
public interface CustomerComponentInterface {
    List<Customer> getAllCustomers();
    void deleteCustomer(int customerId);
    Customer getCustomer(int customerId);
    void addCustomer(Customer customer);
}
