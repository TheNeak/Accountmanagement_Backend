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
    private BookingPositionRepository bookingPositionRepository;

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
        sourceBankAccount.addMoney(-money);
        BookingPosition sourceBp = new BookingPosition(-money);
        bookingPositionRepository.save(sourceBp);
        sourceBankAccount.bookingPositions.add(sourceBp);

        targetBankAccount.addMoney(money);
        BookingPosition targetBp = new BookingPosition(money);
        bookingPositionRepository.save(targetBp);
        targetBankAccount.bookingPositions.add(targetBp);

        sourceBankAccount.getBank().increaseReservationStatistics();
    }
}
