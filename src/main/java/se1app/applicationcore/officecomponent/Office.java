package se1app.applicationcore.officecomponent;

import org.springframework.data.annotation.Id;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;

/**
 * Created by Neak on 03.12.2016.
 */
public class Office {
    @Id
    @GeneratedValue
    private Integer id;

    // Der Filmtitel ist unser fachlicher Schlüssel (zusätzlich zum technischen oben)
    // Deshalb markieren wir ihn für JPA mit Unique
    @Column(unique=true)
    private Integer officeNr;

    private Integer numberOfReservations;

    public Office()
    {
    }

    public Office(String title)
    {
        this.officeNr = officeNr;
        this.numberOfReservations = 0;
    }

    public Integer getId() {
        return id;
    }


    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOfficeNr() {
        return officeNr;
    }

    public void setOfficeNr(Integer officeNr) {
        this.officeNr = officeNr;
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

        Office office = (Office) o;

        if (id != null ? !id.equals(office.id) : office.id != null) return false;
        if (officeNr != null ? !officeNr.equals(office.officeNr) : office.officeNr != null) return false;
        return numberOfReservations != null ? numberOfReservations.equals(office.numberOfReservations) : office.numberOfReservations == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (officeNr != null ? officeNr.hashCode() : 0);
        result = 31 * result + (numberOfReservations != null ? numberOfReservations.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Office{" +
                "id=" + id +
                ", officeNr=" + officeNr +
                ", numberOfReservations=" + numberOfReservations +
                '}';
    }
}
