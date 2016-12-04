package se1app.applicationcore.officecomponent;

/**
 * Created by Neak on 03.12.2016.
 */
public interface OfficeComponentInterface {
    /**
     * Liefert die Anzahl der für den gegebenen Film (Titel) getätigten Reservierungen.
     */
    int getNumberOfReservations(Integer officeNr) throws OfficeNotFoundException;
}
