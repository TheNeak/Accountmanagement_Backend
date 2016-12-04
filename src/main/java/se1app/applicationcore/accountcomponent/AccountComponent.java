package se1app.applicationcore.accountcomponent;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Neak on 03.12.2016.
 */
public class AccountComponent implements AccountComponentInterface {

    private AccountRepository accountRepository;

    @Autowired
    public AccountComponent(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public int getMoneyOfAccount(Integer accountNr) throws AccountNotFoundException {
        Account acc = accountRepository.findByNr(accountNr);
        if (acc == null) {
            throw new AccountNotFoundException(accountNr);
        }
        return acc.getMoney();
    }

    @Override
    public void transferMoney(Integer sourceAccountNr, Integer targetAccountNr, Integer money) throws AccountNotFoundException, AccountIsLowOnMoenyException {
        Account sourceAccount = accountRepository.findByNr(sourceAccountNr);
        Account targetAccount = accountRepository.findByNr(targetAccountNr);
        if (sourceAccount == null) {
            throw new AccountNotFoundException(sourceAccountNr);
        }
        if (targetAccount == null) {
            throw new AccountNotFoundException(targetAccountNr);
        }
        if (sourceAccount.getMoney() < money) {
            throw new AccountIsLowOnMoenyException(sourceAccountNr);
        }
        Integer sourceMoney = sourceAccount.getMoney();
        Integer targetMoney = targetAccount.getMoney();
        sourceAccount.setMoney(sourceMoney - money);
        targetAccount.setMoney(targetMoney + money);

    }

}
