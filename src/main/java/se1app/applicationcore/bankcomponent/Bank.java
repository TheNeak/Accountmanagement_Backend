package se1app.applicationcore.bankcomponent;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by Neak on 03.12.2016.
 */
@Entity
public class Bank {

    @Id
    @GeneratedValue
    private Integer id;

    private Integer nr;

    private Integer numberOfReservations;

    public Bank() {
    }

    public Bank(Integer nr) {
        this.nr = nr;
        this.numberOfReservations = 0;
    }

    public Integer getId() {
        return id;
    }

    public Integer getNr() {
        return nr;
    }

    public void setNr(Integer nr) {
        this.nr = nr;
    }

    public void setNumberOfReservations(Integer numberOfReservations) {
        this.numberOfReservations = numberOfReservations;
    }

    public Integer getNumberOfReservations() {
        return numberOfReservations;
    }

    public void increaseReservationStatistics() {
        numberOfReservations++;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Bank bank = (Bank) o;

        if (id != null ? !id.equals(bank.id) : bank.id != null) return false;
        if (nr != null ? !nr.equals(bank.nr) : bank.nr != null) return false;
        return numberOfReservations != null ? numberOfReservations.equals(bank.numberOfReservations) : bank.numberOfReservations == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (nr != null ? nr.hashCode() : 0);
        result = 31 * result + (numberOfReservations != null ? numberOfReservations.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Bank{" +
                "id=" + id +
                ", nr=" + nr +
                ", numberOfReservations=" + numberOfReservations +
                '}';
    }
}
