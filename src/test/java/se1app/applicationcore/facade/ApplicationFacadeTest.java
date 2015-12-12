package se1app.applicationcore.facade;

import static com.jayway.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.mockito.Mockito.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.http.HttpStatus;
import se1app.applicationcore.Application;
import se1app.applicationcore.customercomponent.Customer;
import se1app.applicationcore.customercomponent.CustomerRepository;
import se1app.applicationcore.reservationcomponent.Reservation;

import java.util.Arrays;
import java.util.List;
import java.util.LinkedList;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebIntegrationTest("server.port:0")
@ActiveProfiles("test")
public class ApplicationFacadeTest {

    @Autowired
    CustomerRepository repository;

    Customer mickey;
    Customer minnie;
    Customer pluto;

    @Value("${local.server.port}")
    int serverPort;

    @Before
    public void setUp() {

        mickey = new Customer("Mickey Mouse");
        minnie = new Customer("Minnie Mouse");
        pluto = new Customer("Pluto");
        Reservation reservation = new Reservation("007");
        pluto.addReservation(reservation);
        reservation.setCustomer(pluto);

        repository.deleteAll();
        repository.save(Arrays.asList(mickey, minnie, pluto));

        port = serverPort;
    }

    @Test
    public void canFetchMickey() {
        Integer mickeyId = mickey.getId();

        when().
                get("/customers/{id}", mickeyId).
                then().
                statusCode(HttpStatus.OK.value()).
                body("name", is("Mickey Mouse")).
                body("id", is(mickeyId));
    }

    @Test
    public void canFetchAll() {
        when().
                get("/customers").
                then().
                statusCode(HttpStatus.OK.value()).
                body("name", hasItems("Mickey Mouse", "Minnie Mouse", "Pluto"));
    }

    @Test
    public void canDeletePluto() {
        Integer plutoId = pluto.getId();

        when()
                .delete("/customers/{id}", plutoId).
                then().
                statusCode(HttpStatus.NO_CONTENT.value());
    }

    @Test
    public void canSaveDonald() {
        Customer donald = new Customer("Donald Duck");

        given().contentType("application/json")
                .body(donald)
                .expect().statusCode(HttpStatus.CREATED.value())
                .when().post("/customers");
    }

    @Test
    public void useMockito() {
        // mock creation
        List mockedList = mock(List.class);

        // using mock object - it does not throw any "unexpected interaction" exception
        mockedList.add("one");
        mockedList.clear();

        // selective, explicit, highly readable verification
        verify(mockedList).add("one");
        verify(mockedList).clear();

        // you can mock concrete classes, not only interfaces
        LinkedList mockedLinkedList = mock(LinkedList.class);

        // stubbing appears before the actual execution
        when(mockedLinkedList.get(0)).thenReturn("first");

        // the following prints "first"
        System.out.println(mockedLinkedList.get(0));

        // the following prints "null" because get(999) was not stubbed
        System.out.println(mockedLinkedList.get(999));
    }
}