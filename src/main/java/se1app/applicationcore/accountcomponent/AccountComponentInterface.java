package se1app.applicationcore.accountcomponent;

/**
 * Created by Neak on 03.12.2016.
 */
public interface AccountComponentInterface {

    /**
     * Liefert den Kontostand der für den gegebenen Account (ID) getätigten Reservierungen.
     */
    int getMoneyOfAccount(Integer accountNr) throws AccountNotFoundException;
}
