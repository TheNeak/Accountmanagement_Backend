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
