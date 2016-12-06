package se1app.applicationcore.bankaccount_component;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import se1app.applicationcore.Application;
import se1app.applicationcore.bank_component.Bank;
import se1app.applicationcore.bank_component.BankRepository;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by abw286 on 06.12.2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(classes = Application.class)
@ActiveProfiles("test")
public class BankBankAccountRepositoryTest {

    @Autowired
    BankAccountRepository bankAccountRepository;

    @Autowired
    BankRepository bankRepository;

    private BankAccount acc01, acc02;
    private Bank bank1, bank2;

    @Before
    public void setUp() throws Exception {
        bank1 = new Bank(1);
        bank2 = new Bank(2);
        bankRepository.save(bank1);
        bankRepository.save(bank2);
        acc01 = new BankAccount(1, bank1);
        acc02 = new BankAccount(2, bank2);
        bankAccountRepository.save(acc01);
        bankAccountRepository.save(acc02);
    }

    @Ignore
    @After
    public void cleanUp() throws Exception {
        bankRepository.deleteAll();
        bankAccountRepository.deleteAll();
    }

    @Test
    public void findAllTest() throws Exception {
        List<BankAccount> bankAccounts = bankAccountRepository.findAll();
        assertThat(bankAccounts).hasSize(2);
        assertThat(bankAccounts).extracting(BankAccount::getAccountNr).contains(1);
        assertThat(bankAccounts).extracting(BankAccount::getAccountNr).contains(2);
        assertThat(bankAccounts).extracting(account -> account.getBank().getNr()).contains(1);
        assertThat(bankAccounts).extracting(account -> account.getBank().getNr()).contains(2);
    }

    @Test
    public void findByAccountNrTest() throws Exception {
        BankAccount bankAccount = bankAccountRepository.findByAccountNr(1);
        assertThat(bankAccount).isEqualTo(acc01);
    }
}