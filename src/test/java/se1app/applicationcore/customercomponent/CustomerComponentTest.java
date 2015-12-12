package se1app.applicationcore.customercomponent;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import se1app.applicationcore.Application;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(classes = Application.class)
@ActiveProfiles("test")
public class CustomerComponentTest {

	@Autowired
    private AutowireCapableBeanFactory beanFactory;

    // KEIN Autowired hier!
	private CustomerComponentInterface customerComponentInterface;

	@Autowired
	private CustomerRepository customerRepository;

	@Before
	public void setup() {
		// Testdaten für den Komponententest initialisieren
		Customer customer = new Customer("Heinz");
		customerRepository.save(customer);

        // wir instanziieren unsere Komponente selber, um Mock-Abhängigkeiten zu übergeben
        customerComponentInterface = new CustomerUseCases();
        // die restlichen Autowired-Felder der CustomerKomponente müssen von Spring geliefert werden
        // hier stoßen wir deshalb den Autowiring-Prozess von Hand an
        // ohne würde es Nullpointerexceptions geben, da die Repositories nicht in der
        // CustomerKomponente instanziiert werden
        beanFactory.autowireBean(customerComponentInterface);
	}

	@Test
	public void testGetAllCustomers(){
        List<Customer> customers = customerComponentInterface.getAllCustomers();
        assertThat(customers).hasSize(1);
    }

    // Hier fehlen die Tests der anderen CustomerComponentInterface-Operationen!!
}
