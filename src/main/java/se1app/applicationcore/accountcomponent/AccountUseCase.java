package se1app.applicationcore.accountcomponent;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Neak on 04.12.2016.
 *
 */
public class AccountUseCase implements AccountUseCaseInterface {

    @Autowired
    private AccountRepository accountRepository;

    private AccountComponentInterface accountComponentInterface;

    public void transfer(Integer sourceAccountNr, Integer targetAccountNr, Integer money) throws AccountNotFoundException, AccountIsLowOnMoneyException {
        accountComponentInterface = new AccountComponent(accountRepository);
        accountComponentInterface.transferMoney(sourceAccountNr, targetAccountNr, money);
    }

}
