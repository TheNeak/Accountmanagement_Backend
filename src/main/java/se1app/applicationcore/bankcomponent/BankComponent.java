package se1app.applicationcore.bankcomponent;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Neak on 03.12.2016.
 */
public class BankComponent implements BankComponentInterface {

    private BankRepository bankRepository;

    @Autowired
    public BankComponent(BankRepository bankRepository)
    {
        this.bankRepository = bankRepository;
    }

    @Override
    public int getNumberOfReservations(Integer officeNr) throws BankNotFoundException {
        Bank bank = bankRepository.findByNr(officeNr);
        if (bank == null)
        {
            throw new BankNotFoundException(officeNr);
        }
        return bank.getNumberOfReservations();
    }


}
