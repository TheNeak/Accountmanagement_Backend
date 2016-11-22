package se1app.applicationcore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import se1app.applicationcore.customercomponent.Customer;
import se1app.applicationcore.customercomponent.CustomerRepository;

import java.util.Arrays;

@SpringBootApplication
public class Application {

    @Bean
    CommandLineRunner init(CustomerRepository customerRepository) {
        return args -> {
            Customer mickey = new Customer("Mueller");
            Customer minnie = new Customer("Meier");
            Customer pluto = new Customer("Schulze");
            customerRepository.save(Arrays.asList(mickey, minnie, pluto));
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
