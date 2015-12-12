package se1app.applicationcore.reservationcomponent;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by srs on 08.12.15.
 */
@Entity
public class Seat {
    @Id
    @GeneratedValue
    private Integer id;

    private Integer row;
    private Integer number;

    @ManyToMany(mappedBy = "seats")
    private List<Reservation> reservations = new ArrayList<>();

    public void addReservation(Reservation reservation)
    {
        this.reservations.add(reservation);
    }

    public Seat()
    {
    }

    @Override
    public boolean equals(Object o) {
        if(o instanceof Seat){
            Seat toCompare = (Seat) o;
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
                "Seat[id=%d, row='%s', number='%s']",
                id, row, number);
    }
}
