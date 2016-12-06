package se1app.applicationcore.accountcomponent;

/**
 * Created by abw286 on 06.12.2016.
 *
 */
public interface AccountUseCaseInterface {

    public void transferMoney(Integer sourceAccountNr, Integer targetAccountNr, Integer money) throws AccountNotFoundException, AccountIsLowOnMoneyException;

}
