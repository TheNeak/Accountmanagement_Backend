package se1app.applicationcore.bankaccount_component;

/**
 * Created by abw286 on 06.12.2016.
 *
 */
public interface BankAccountUseCaseInterface {

    void transferMoney(Integer sourceAccountNr, Integer targetAccountNr, Integer money) throws BankAccountNotFoundException, BankAccountIsLowOnMoneyException;

    void bookMoney(Integer accountNr, Integer amount);
}
