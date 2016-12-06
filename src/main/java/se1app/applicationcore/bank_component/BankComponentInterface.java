package se1app.applicationcore.bank_component;

import java.util.List;

/**
 * Created by Neak on 03.12.2016.
 */
public interface BankComponentInterface {

    /**
     * Liefert alle Bank.
     *
     * @return Liste von Customer, leere Liste, falls keine Bank vorhanden.
     */
    List<Bank> getAllBanks();

    /**
     * Löscht einen Bank.
     */
    void deleteBank(int positiveBankId);

    /**
     * Löscht einen Bank.
     */
    void deleteBank(Bank bank);

    /**
     * Sucht einen Bank.
     */
    Bank getBank(int positiveBankId);

    /**
     * Fügt der Komponente einen Bank hinzu.
     */
    void addBank(Bank bank);

    /**
     * Liefert die Anzahl der für den gegebenen Film (Titel) getätigten Reservierungen.
     */
    int getNumberOfReservations(Integer officeNr) throws BankNotFoundException;
}
