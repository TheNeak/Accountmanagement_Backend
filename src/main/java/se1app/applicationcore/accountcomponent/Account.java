package se1app.applicationcore.accountcomponent;

import org.hibernate.annotations.CascadeType;
import se1app.applicationcore.officecomponent.Office;

import javax.persistence.*;

/**
 * Created by Neak on 03.12.2016.
 */
public class Account {
    @Id
    @GeneratedValue
    private Integer id;

    @Column(unique=true)
    private Integer nr;

    private Integer money;

    @ManyToOne
    private Office office;

    @OneToMany
    private BookingPosition bookingPosition;

    public Account(Office office)
    {
        this.office = office;
    }
    public Account(Integer nr, Integer money, Office office)
    {
        this.nr = nr;
        this.money = money;
        this.office = office;
    }

    public Office getOffice() {
        return office;
    }

    public void setOffice(Office office) {
        this.office = office;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNr() {
        return nr;
    }

    public void setNr(Integer nr) {
        this.nr = nr;
    }

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Account account = (Account) o;

        if (id != null ? !id.equals(account.id) : account.id != null) return false;
        if (nr != null ? !nr.equals(account.nr) : account.nr != null) return false;
        if (money != null ? !money.equals(account.money) : account.money != null) return false;
        return office != null ? office.equals(account.office) : account.office == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (nr != null ? nr.hashCode() : 0);
        result = 31 * result + (money != null ? money.hashCode() : 0);
        result = 31 * result + (office != null ? office.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", nr=" + nr +
                ", money=" + money +
                ", office=" + office +
                '}';
    }
}
