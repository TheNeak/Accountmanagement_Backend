package se1app.applicationcore.accountcomponent;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import se1app.applicationcore.Application;
import se1app.applicationcore.bankcomponent.Bank;
import se1app.applicationcore.bankcomponent.BankRepository;

/**
 * Created by abw286 on 06.12.2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(classes = Application.class)
@ActiveProfiles("test")
public class BankAccountComponentTest {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private BankRepository bankRepository;

    // KEIN Autowired hier!
    private BankAccountComponentInterface testObject;
    private BankAccount sourceBankAccount, targetBankAccount;
    private Bank bank;

    @Before
    public void setUp() throws Exception {
        // Testdaten für den Komponententest initialisieren
        bank = new Bank(1);
        bankRepository.save(bank);
        sourceBankAccount = new BankAccount(1, bank);
        targetBankAccount = new BankAccount(2, bank);
        accountRepository.save(sourceBankAccount);
        accountRepository.save(targetBankAccount);

        // wir instanziieren unsere Komponente selber, um Mock-Abhängigkeiten zu übergeben
        testObject = new BankBankAccountComponent(accountRepository);
    }

    @Test
    public void getMoneyOfAccount() throws Exception {
        // TODO
    }

    @Test
    public void transferMoney() throws Exception {
        // TODO
    }

}