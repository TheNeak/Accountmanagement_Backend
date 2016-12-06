package se1app.applicationcore.accountcomponent;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Neak on 04.12.2016.
 *
 */
public class AccountUseCase implements AccountUseCaseInterface {

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public void transferMoney(Integer sourceAccountNr, Integer targetAccountNr, Integer money) throws BankAccountNotFoundException, BankAccountIsLowOnMoneyException {
        BankAccount sourceBankAccount = accountRepository.findByAccountNr(sourceAccountNr);
        BankAccount targetBankAccount = accountRepository.findByAccountNr(targetAccountNr);
        if (sourceBankAccount == null) {
            throw new BankAccountNotFoundException(sourceAccountNr);
        }
        if (targetBankAccount == null) {
            throw new BankAccountNotFoundException(targetAccountNr);
        }
        if (sourceBankAccount.getMoney() < money) {
            throw new BankAccountIsLowOnMoneyException(sourceAccountNr);
        }
        sourceBankAccount.book(-money);
        targetBankAccount.book(money);
        sourceBankAccount.getBank().increaseReservationStatistics();
    }
}
