package se1app.applicationcore.accountcomponent;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by Neak on 04.12.2016.
 */
public class BookingPosition {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(unique=true)
    private Integer bookedMoney;

    public BookingPosition(Integer bookedMoney) {
        this.bookedMoney = bookedMoney;
    }

    public Integer getBookedMoney() {
        return bookedMoney;
    }
}
