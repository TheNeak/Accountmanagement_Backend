package se1app.applicationcore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import se1app.applicationcore.bank_component.Bank;
import se1app.applicationcore.bank_component.BankRepository;
import se1app.applicationcore.bankaccount_component.BankAccount;
import se1app.applicationcore.bankaccount_component.BankAccountRepository;
import se1app.applicationcore.customer_component.Customer;
import se1app.applicationcore.customer_component.CustomerRepository;

import java.util.Arrays;

@SpringBootApplication
public class Application {

    @Bean
    CommandLineRunner init(CustomerRepository customerRepository, BankRepository bankRepository, BankAccountRepository bankAccountRepository) {
        return args -> {
            Customer mickey = new Customer("Mueller");
            Customer minnie = new Customer("Meier");
            Customer pluto = new Customer("Schulze");
            customerRepository.save(Arrays.asList(mickey, minnie, pluto));

            Bank bank01 = new Bank(01);
            bankRepository.save(bank01);
            BankAccount acc01 = new BankAccount(1,bank01);
            BankAccount acc02 = new BankAccount(2,bank01);
            BankAccount acc03 = new BankAccount(3,bank01);
            bankAccountRepository.save(Arrays.asList(acc01, acc02, acc03));

        };
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
