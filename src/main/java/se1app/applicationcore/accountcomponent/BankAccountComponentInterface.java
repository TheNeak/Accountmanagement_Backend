package se1app.applicationcore.accountcomponent;

/**
 * Created by Neak on 03.12.2016.
 */
public interface BankAccountComponentInterface {



    /**
     * Liefert den Kontostand der für den gegebenen BankAccount (ID) getätigten Reservierungen.
     */
    int getMoneyOfAccount(Integer accountNr) throws BankAccountNotFoundException;


    /**
     * Transfers an amount of money from one bankaccount to anther
     *
     * @param sourceAccountNr
     * @param targetAccountNr
     * @param money
     * @throws BankAccountNotFoundException
     * @throws BankAccountIsLowOnMoneyException
     */
    void transferMoney(Integer sourceAccountNr, Integer targetAccountNr, Integer money) throws BankAccountNotFoundException, BankAccountIsLowOnMoneyException;
}
