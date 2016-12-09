package se1app.applicationcore.bankaccount_component;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Neak on 04.12.2016.
 *
 */
public class BankAccountUseCase implements BankAccountUseCaseInterface {

    @Autowired
    private BankAccountRepository bankAccountRepository;

    @Autowired
    private BankAccountComponentInterface bankAccountComponentInterface;

    @Override
    public void transferMoney(Integer sourceAccountNr, Integer targetAccountNr, Integer money) throws BankAccountNotFoundException, BankAccountIsLowOnMoneyException {
        BankAccount sourceBankAccount = bankAccountRepository.findByAccountNr(sourceAccountNr);
        BankAccount targetBankAccount = bankAccountRepository.findByAccountNr(targetAccountNr);
        if (sourceBankAccount == null) {
            throw new BankAccountNotFoundException(sourceAccountNr);
        }
        if (targetBankAccount == null) {
            throw new BankAccountNotFoundException(targetAccountNr);
        }
        if (sourceBankAccount.getMoney() < money) {
            throw new BankAccountIsLowOnMoneyException(sourceAccountNr);
        }

        bankAccountComponentInterface.bookMoney(sourceAccountNr, -money);
        bankAccountComponentInterface.bookMoney(targetAccountNr, money);

    }
}
