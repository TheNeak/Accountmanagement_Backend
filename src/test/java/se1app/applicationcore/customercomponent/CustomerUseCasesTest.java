package se1app.applicationcore.customercomponent;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import se1app.applicationcore.Application;
import se1app.applicationcore.customercomponent.Customer;
import se1app.applicationcore.customercomponent.CustomerRepository;
import se1app.applicationcore.customercomponent.CustomerUseCases;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(classes = Application.class)
public class CustomerUseCasesTest {

	@Autowired
	private CustomerUseCases customerUseCases;

	@Autowired
	private CustomerRepository customerRepository;

	@Before
	public void setup() {
		Customer customer = new Customer("Heinz");
		customerRepository.save(customer);
	}

	@Test
	public void testFindAll(){
		//CustomerUseCases customerUseCases = new CustomerUseCases();
		customerUseCases.doSomething();
	}
}
