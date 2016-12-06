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
        Account acc = accountRepository.findByAccountNr(accountNr);
        if (acc == null) {
            throw new AccountNotFoundException(accountNr);
        }
        return acc.getMoney();
    }

    @Override
    public void transferMoney(Integer sourceAccountNr, Integer targetAccountNr, Integer money) throws AccountNotFoundException, AccountIsLowOnMoneyException {
        Account sourceAccount = accountRepository.findByAccountNr(sourceAccountNr);
        Account targetAccount = accountRepository.findByAccountNr(targetAccountNr);
        if (sourceAccount == null) {
            throw new AccountNotFoundException(sourceAccountNr);
        }
        if (targetAccount == null) {
            throw new AccountNotFoundException(targetAccountNr);
        }
        if (sourceAccount.getMoney() < money) {
            throw new AccountIsLowOnMoneyException(sourceAccountNr);
        }
        sourceAccount.book(-money);
        targetAccount.book(money);
        sourceAccount.getOffice().increaseReservationStatistics();
    }

}
