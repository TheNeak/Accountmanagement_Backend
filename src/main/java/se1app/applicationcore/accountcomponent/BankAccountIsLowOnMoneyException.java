package se1app.applicationcore.accountcomponent;

/**
 * Created by Neak on 04.12.2016.
 */
public class BankAccountIsLowOnMoneyException extends Exception {
    private static final long serialVersionUID = 5234151235599771228L;

    public BankAccountIsLowOnMoneyException(Integer accountNr) {
        super("account with id " + accountNr + " is low on money");
    }
}
