package se1app.applicationcore.bankaccount_component;

import se1app.applicationcore.bank_component.Bank;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Neak on 03.12.2016.
 */
@Entity
public class BankAccount {
    @Id
    @GeneratedValue
    private Integer id;

    @Column(unique=true)
    private Integer accountNr;

    private Integer money;

    @ManyToOne
    private Bank bank;

    @OneToMany(cascade = CascadeType.ALL)
    private List<BookingPosition> bookingPositions;

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
    public void setMoney(Integer amount){ this.money = amount; }

    public void book(Integer amount){
        bookingPositions.add(new BookingPosition(amount));
        this.money += amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BankAccount bankAccount = (BankAccount) o;

        if (id != null ? !id.equals(bankAccount.id) : bankAccount.id != null) return false;
        if (accountNr != null ? !accountNr.equals(bankAccount.accountNr) : bankAccount.accountNr != null) return false;
        if (money != null ? !money.equals(bankAccount.money) : bankAccount.money != null) return false;
        return bank != null ? bank.equals(bankAccount.bank) : bankAccount.bank == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (accountNr != null ? accountNr.hashCode() : 0);
        result = 31 * result + (money != null ? money.hashCode() : 0);
        result = 31 * result + (bank != null ? bank.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "id=" + id +
                ", accountNr=" + accountNr +
                ", money=" + money +
                ", bank=" + bank +
                '}';
    }
}
