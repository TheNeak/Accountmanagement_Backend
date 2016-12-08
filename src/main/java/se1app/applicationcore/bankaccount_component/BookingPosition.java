package se1app.applicationcore.bankaccount_component;

import javax.persistence.*;
import java.io.Serializable;
import java.lang.annotation.Annotation;

/**
 * Created by Neak on 04.12.2016.
 */
@Entity
public class BookingPosition implements Serializable{

    @Id
    @GeneratedValue
    private Integer id;

    private Integer bookedMoney;

    public BookingPosition(Integer bookedMoney) {
        this.bookedMoney = bookedMoney;
    }

    public Integer getBookedMoney() {
        return bookedMoney;
    }

    public Integer getId() {
        return id;
    }
}
