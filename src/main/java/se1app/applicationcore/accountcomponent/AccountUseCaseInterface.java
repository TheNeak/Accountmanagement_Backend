package se1app.applicationcore.accountcomponent;

/**
 * Created by abw286 on 06.12.2016.
 */
public interface AccountUseCaseInterface {
    public void transfer(Integer sour, Integer tar, Integer mon) throws AccountNotFoundException, AccountIsLowOnMoneyException;
}
