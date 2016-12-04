package se1app.applicationcore.accountcomponent;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Neak on 03.12.2016.
 */
public class AccountComponent implements AccountComponentInterface{

    private AccountRepository accountRepository;

    @Autowired
    public AccountComponent(AccountRepository accountRepository)
    {
        this.accountRepository =accountRepository;
    }

    @Override
    public int getMoneyOfAccount(Integer accountNr) throws AccountNotFoundException {
        Account acc = accountRepository.findByNr(accountNr);
        if (acc == null)
        {
            throw new AccountNotFoundException(accountNr);
        }
        return acc.getMoney();
    }


}
