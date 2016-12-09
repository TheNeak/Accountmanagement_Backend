package se1app.applicationcore.bankaccount_component;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by Neak on 04.12.2016.
 */
@Entity
public class BookingPosition {

    @Id
    @GeneratedValue
    private Integer id;

    private Integer bookedMoney = 0;

    public BookingPosition() {

    }

    public BookingPosition(Integer bookedMoney) {
        this.bookedMoney = bookedMoney;
    }

    public Integer getBookedMoney() {
        return bookedMoney;
    }

    public void setBookedMoney(Integer bookedMoney) {
        this.bookedMoney = bookedMoney;
    }

    public Integer getId() {
        return id;
    }
}
