package se1app.applicationcore.customercomponent;

import java.util.List;

/**
 * Created by srs on 12.12.15.
 */
public interface CustomerComponentInterface {
    // Bei den folgenden Methoden fehlt die Dokumentation
    List<Customer> getAllCustomers();
    void deleteCustomer(Integer customerId);
    Customer getCustomer(Integer customerId);
    void addCustomer(Customer customer);

    void addReservation(Integer customerId, Reservation reservationToAdd);
}
