package se1app.applicationcore.bankaccount_component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se1app.applicationcore.bank_component.Bank;
import se1app.applicationcore.bank_component.BankRepository;

@Service
public class BankAccountUseCase implements BankAccountUseCaseInterface {

    private BankAccountRepository bankAccountRepository;

    private BookingPositionRepository bookingPositionRepository;

    private BankRepository bankRepository;

    @Autowired
    public BankAccountUseCase(BankAccountRepository bankAccountRepository, BookingPositionRepository bookingPositionRepository, BankRepository bankRepository) {
        this.bankAccountRepository = bankAccountRepository;
        this.bookingPositionRepository = bookingPositionRepository;
        this.bankRepository = bankRepository;
    }

    public BankAccountUseCase() {
    }

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

        bookMoney(sourceAccountNr, -money);
        bookMoney(targetAccountNr, money);

    }

    @Override
    public void bookMoney(Integer accountNr, Integer amount) {
        BankAccount bankAccount = bankAccountRepository.findByAccountNr(accountNr);
        bankAccount.addMoney(amount);
        BookingPosition bp = new BookingPosition(amount);
        bookingPositionRepository.save(bp);
        bankAccount.bookingPositions.add(bp);
        Bank sourceBank = bankRepository.findByNr(bankAccount.getBank().getId());
        sourceBank.increaseReservationStatistics();
        bankRepository.save(sourceBank);
        bankAccountRepository.save(bankAccount);
    }
}
