package se1app.applicationcore.bank_component;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Neak on 03.12.2016.
 */
public class BankComponent implements BankComponentInterface {

    private BankRepository bankRepository;

    @Autowired
    public BankComponent(BankRepository bankRepository) {
        this.bankRepository = bankRepository;
    }

    @Override
    public List<Bank> getAllBanks() {
        return bankRepository.findAll();
    }

    @Override
    public void deleteBank(int positiveBankId) {
        if (positiveBankId <= 0)
            throw new IllegalArgumentException("positiveBankId must be > 0");

        bankRepository.delete(positiveBankId);
    }

    @Override
    public void deleteBank(Bank bank) {
        if (bank == null)
            throw new IllegalArgumentException("bank must not be null");

        bankRepository.delete(bank);
    }

    @Override
    public Bank getBank(int positiveBankId) {
        if (positiveBankId <= 0)
            throw new IllegalArgumentException("positiveBankId must be > 0");

        return bankRepository.findOne(positiveBankId);
    }

    @Override
    public void addBank(Bank bank) {
        if (bank == null)
            throw new IllegalArgumentException("bank must not be null");

        bankRepository.save(bank);
    }

    @Override
    public int getNumberOfReservations(Integer officeNr) throws BankNotFoundException {
        if (officeNr <= 0)
            throw new IllegalArgumentException("officeNr must be > 0");

        Bank bank = bankRepository.findByNr(officeNr);
        if (bank == null) {
            throw new BankNotFoundException(officeNr);
        }
        return bank.getNumberOfReservations();
    }


}
