package se1app.applicationcore.bank_component;

/**
 * Created by Neak on 04.12.2016.
 *
 */
public class BankNotFoundException extends Exception {
    private static final long serialVersionUID = 5234151235599771228L;

    public BankNotFoundException(Integer officeNr) {
        super("office with nr " + officeNr + " was not found");
    }
}

