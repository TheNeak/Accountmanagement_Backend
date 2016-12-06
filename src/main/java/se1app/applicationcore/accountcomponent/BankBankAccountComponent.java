package se1app.applicationcore.accountcomponent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Neak on 03.12.2016.
 */
@Component
public class BankBankAccountComponent implements BankAccountComponentInterface {

    // Autowired by Constructor!
    private AccountRepository accountRepository;

    private BankAccountComponentInterface bankAccountComponentInterface;




    @Autowired
    public BankBankAccountComponent(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public int getMoneyOfAccount(Integer accountNr) throws BankAccountNotFoundException {
        BankAccount acc = accountRepository.findByAccountNr(accountNr);
        if (acc == null) {
            throw new BankAccountNotFoundException(accountNr);
        }
        return acc.getMoney();
    }

    public void transferMoney(Integer sourceAccountNr, Integer targetAccountNr, Integer money) throws BankAccountNotFoundException, BankAccountIsLowOnMoneyException {
        bankAccountComponentInterface = new BankBankAccountComponent(accountRepository);
        bankAccountComponentInterface.transferMoney(sourceAccountNr, targetAccountNr, money);
    }

}
