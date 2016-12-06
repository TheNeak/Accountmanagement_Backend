package se1app.applicationcore.bank_component;

/**
 * Created by Neak on 03.12.2016.
 */
public interface BankComponentInterface {
    /**
     * Liefert die Anzahl der für den gegebenen Film (Titel) getätigten Reservierungen.
     */
    int getNumberOfReservations(Integer officeNr) throws BankNotFoundException;
}
