package se1app.applicationcore.bankaccount_component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Neak on 03.12.2016.
 */
@Component
public class BankBankAccountComponent implements BankAccountComponentInterface {

    // Autowired by Constructor!
    private BankAccountRepository bankAccountRepository;

    private BankAccountComponentInterface bankAccountComponentInterface;




    @Autowired
    public BankBankAccountComponent(BankAccountRepository bankAccountRepository) {
        this.bankAccountRepository = bankAccountRepository;
    }

    @Override
    public int getMoneyOfAccount(Integer accountNr) throws BankAccountNotFoundException {
        BankAccount acc = bankAccountRepository.findByAccountNr(accountNr);
        if (acc == null) {
            throw new BankAccountNotFoundException(accountNr);
        }
        return acc.getMoney();
    }

    public void transferMoney(Integer sourceAccountNr, Integer targetAccountNr, Integer money) throws BankAccountNotFoundException, BankAccountIsLowOnMoneyException {
        bankAccountComponentInterface = new BankBankAccountComponent(bankAccountRepository);
        bankAccountComponentInterface.transferMoney(sourceAccountNr, targetAccountNr, money);
    }

}
