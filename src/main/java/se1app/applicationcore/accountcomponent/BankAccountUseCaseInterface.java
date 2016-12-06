package se1app.applicationcore.accountcomponent;

/**
 * Created by abw286 on 06.12.2016.
 *
 */
public interface BankAccountUseCaseInterface {

    public void transferMoney(Integer sourceAccountNr, Integer targetAccountNr, Integer money) throws BankAccountNotFoundException, BankAccountIsLowOnMoneyException;

}
