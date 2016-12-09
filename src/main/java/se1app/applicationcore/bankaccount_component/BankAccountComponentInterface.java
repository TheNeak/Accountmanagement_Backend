package se1app.applicationcore.bankaccount_component;

import java.util.List;

/**
 * Created by Neak on 03.12.2016.
 */
public interface BankAccountComponentInterface {

    /**
     * Liefert alle BankAccount.
     *
     * @return Liste von Customer, leere Liste, falls keine BankAccount vorhanden.
     */
    List<BankAccount> getAllBankAccounts();

    /**
     * Löscht einen BankAccount.
     */
    void deleteBankAccount(int positiveBankAccountId);

    /**
     * Löscht einen BankAccount.
     */
    void deleteBankAccount(BankAccount bankAccount);

    /**
     * Sucht einen BankAccount.
     */
    BankAccount getBankAccount(int positiveBankAccountId);

    /**
     * Fügt der Komponente einen BankAccount hinzu.
     */
    void addBankAccount(BankAccount bankAccount);

    /**
     * Fügt dem Konto Geld hinzu.
     */
    void bookMoney(Integer accountNr, Integer amount);

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
