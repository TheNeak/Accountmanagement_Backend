package se1app.applicationcore.bankaccount_component;


import se1app.applicationcore.bank_component.Bank;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Neak on 03.12.2016.
 */
@Entity
public class BankAccount {
    @ElementCollection
    @OneToMany(cascade = CascadeType.ALL)
    protected static List<BookingPosition> bookingPositions = new ArrayList<>();
    @Id
    @GeneratedValue
    private Integer id;
    @Column(unique=true)
    private Integer accountNr;
    private Integer money = 0;
    @ManyToOne
    private Bank bank;

    public BankAccount() {
    }

    public BankAccount(Integer accountNr, Bank bank) {
        this.accountNr = accountNr;
        this.bank = bank;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public Integer getAccountNr() {
        return accountNr;
    }

    public Integer getMoney() {
        int money=0;
        for (BookingPosition bookingPosition : bookingPositions){
            money += bookingPosition.getBookedMoney();
        }
        return money;
    }

    public void addMoney(Integer amount) {
        this.money = this.money + amount;
    }

    public List<BookingPosition> getBookingPositions() {
        return bookingPositions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BankAccount that = (BankAccount) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (accountNr != null ? !accountNr.equals(that.accountNr) : that.accountNr != null) return false;
        if (money != null ? !money.equals(that.money) : that.money != null) return false;
        if (bank != null ? !bank.equals(that.bank) : that.bank != null) return false;
        return bookingPositions != null ? bookingPositions.equals(that.bookingPositions) : that.bookingPositions == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (accountNr != null ? accountNr.hashCode() : 0);
        result = 31 * result + (money != null ? money.hashCode() : 0);
        result = 31 * result + (bank != null ? bank.hashCode() : 0);
        result = 31 * result + (bookingPositions != null ? bookingPositions.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "id=" + id +
                ", accountNr=" + accountNr +
                ", money=" + money +
                ", bank=" + bank +
                ", bookingPositions=" + bookingPositions +
                '}';
    }
}
