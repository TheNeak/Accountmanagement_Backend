package se1app.applicationcore.reservationcomponent;

import com.fasterxml.jackson.annotation.JsonIgnore;
import se1app.applicationcore.customercomponent.Customer;

import javax.persistence.*;
import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Reservation {

    @Id
    @GeneratedValue
    private Integer id;

    private String movie;

    @JsonIgnore
    @ManyToOne
    private Customer customer;

    @ManyToMany
    private List<Seat> seats = new ArrayList<>();

    public Reservation() {}

    public Reservation(String movie)
    {
        this.movie = movie;
    }

    public Integer getId() {
        return id;
    }

    public String getMovie() {
        return movie;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void addSeat(Seat seat)
    {
        this.seats.add(seat);
    }

    @Override
    public boolean equals(Object o) {
        if(o instanceof Reservation){
            Reservation toCompare = (Reservation) o;
            return this.id.equals(toCompare.id);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        return String.format(
                "Reservation[id=%d, movie='%s']",
                id, movie);
    }
}