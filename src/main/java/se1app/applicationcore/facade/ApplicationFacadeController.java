package se1app.applicationcore.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se1app.applicationcore.bankaccount_component.BankAccount;
import se1app.applicationcore.bankaccount_component.BankAccountComponentInterface;
import se1app.applicationcore.bankaccount_component.BankAccountIsLowOnMoneyException;
import se1app.applicationcore.bankaccount_component.BankAccountNotFoundException;
import se1app.applicationcore.customer_component.Customer;
import se1app.applicationcore.customer_component.CustomerComponentInterface;
import se1app.applicationcore.customer_component.CustomerNotFoundException;
import se1app.applicationcore.customer_component.Reservation;
import se1app.applicationcore.movie_component.MovieComponentInterface;
import se1app.applicationcore.movie_component.MovieNotFoundException;

import java.util.List;

@RestController
class ApplicationFacadeController {

    @Autowired
    private CustomerComponentInterface customerComponentInterface;

    @Autowired
    private MovieComponentInterface movieComponentInterface;

    @Autowired
    private BankAccountComponentInterface bankAccountComponentInterface;


    @RequestMapping("/transactions")
    public List<BankAccount> getAllBankAccounts()
    {
        return bankAccountComponentInterface.getAllBankAccounts();
    }

    @RequestMapping(value = "/transactions/{accountNr}", method = RequestMethod.GET)
    public BankAccount getBankAccount(@PathVariable("accountNr") Integer accountNr) {
        return bankAccountComponentInterface.getBankAccount(accountNr);
    }

    @RequestMapping(value = "/transactions/{accountNr}/add/{money}", method = RequestMethod.GET)
    public String addMoney(@PathVariable("accountNr") Integer accountNr, @PathVariable("money") Integer money) throws BankAccountNotFoundException, BankAccountIsLowOnMoneyException {
        bankAccountComponentInterface.bookMoney(accountNr, money);
        return "The amount of "+money+"€ was added to account"+accountNr;
    }

    @RequestMapping(value = "/transactions/transfer/{money}", method = RequestMethod.GET)
    public String transferMoney(@PathVariable("money") Integer money) throws BankAccountNotFoundException, BankAccountIsLowOnMoneyException {
        bankAccountComponentInterface.transferMoney(01,02,money);
        return "The amount of "+money+"€ was sent from 01 to 02";
    }

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
    public ResponseEntity<?> addReservation(@PathVariable("id") Integer customerId, @RequestBody Reservation reservation) {
        try {
            customerComponentInterface.addReservation(customerId, reservation);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
        catch(CustomerNotFoundException ex) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        catch(Exception ex)
        {
            return new ResponseEntity<String>(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/movies/{title}", method = RequestMethod.GET)
    public ResponseEntity<?> getNumberOfReservations(@PathVariable("title") String title) {
        try {
            int numberOfReservations = movieComponentInterface.getNumberOfReservations(title);
            return new ResponseEntity<Integer>(numberOfReservations, HttpStatus.OK);
        }
        catch(MovieNotFoundException ex) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        catch(Exception ex)
        {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}