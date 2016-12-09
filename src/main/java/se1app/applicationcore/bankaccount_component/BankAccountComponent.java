package se1app.applicationcore.bankaccount_component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import se1app.applicationcore.bank_component.Bank;
import se1app.applicationcore.bank_component.BankComponentInterface;
import se1app.applicationcore.bank_component.BankRepository;

import java.util.List;

/**
 * Created by Neak on 03.12.2016.
 */
@Component
public class BankAccountComponent implements BankAccountComponentInterface {

    // Autowired by Constructor!
    private BankAccountRepository bankAccountRepository;

    private BookingPositionRepository bookingPositionRepository;

    private BankRepository bankRepository;

    private BankComponentInterface bankComponentInterface;

    private BankAccountUseCase baUseCase = new BankAccountUseCase();


    @Autowired
    public BankAccountComponent(BankAccountRepository bankAccountRepository, BookingPositionRepository bookingPositionRepository, BankRepository bankRepository) {
        this.bankAccountRepository = bankAccountRepository;
        this.bookingPositionRepository = bookingPositionRepository;
        this.bankRepository = bankRepository;
    }

    @Override
    public List<BankAccount> getAllBankAccounts() {
        return bankAccountRepository.findAll();
    }

    @Override
    public void deleteBankAccount(int positiveBankAccountId) {
        if (positiveBankAccountId <= 0)
            throw new IllegalArgumentException("bankAccountId must be > 0");

        bankAccountRepository.delete(positiveBankAccountId);
    }

    @Override
    public void deleteBankAccount(BankAccount bankAccount) {
        if (bankAccount == null)
            throw new IllegalArgumentException("bankAccount must not be null");

        bankAccountRepository.delete(bankAccount);
    }

    @Override
    public BankAccount getBankAccount(int positiveBankAccountId) {
        if (positiveBankAccountId <= 0)
            throw new IllegalArgumentException("bankAccountId must be > 0");
        return bankAccountRepository.findByAccountNr(positiveBankAccountId);
    }

    @Override
    public void addBankAccount(BankAccount bankAccount) {
        bankAccountRepository.save(bankAccount);
    }

    @Override
    public int getMoneyOfAccount(Integer accountNr) throws BankAccountNotFoundException {
        if (accountNr <= 0)
            throw new IllegalArgumentException("bankAccountId must be > 0");

        BankAccount acc = bankAccountRepository.findByAccountNr(accountNr);
        if (acc == null) {
            throw new BankAccountNotFoundException(accountNr);
        }
        return acc.getMoney();
    }

    @Override
    public void bookMoney(Integer accountNr, Integer amount) {
        BankAccount bankAccount = bankAccountRepository.findByAccountNr(accountNr);
        Bank sourceBank = bankRepository.findByNr(bankAccount.getBank().getNr());
        bankAccount.addMoney(amount);
        BookingPosition bp = new BookingPosition(amount);
        bookingPositionRepository.save(bp);
        bankAccount.bookingPositions.add(bp);
        bankComponentInterface.increaseReservationStatistics(sourceBank);
        bankRepository.save(sourceBank);
        bankAccountRepository.save(bankAccount);
    }

    public void transferMoney(Integer sourceAccountNr, Integer targetAccountNr, Integer money) throws BankAccountNotFoundException, BankAccountIsLowOnMoneyException {
        if (sourceAccountNr == null)
            throw new IllegalArgumentException("sourceAccountNr must not be null");
        if (targetAccountNr == null)
            throw new IllegalArgumentException("targetAccountNr must not be null");
        if (money == null)
            throw new IllegalArgumentException("money must not be null");

        baUseCase.transferMoney(sourceAccountNr, targetAccountNr, money);
    }

}
