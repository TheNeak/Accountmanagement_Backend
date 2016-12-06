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
import se1app.applicationcore.officecomponent.Office;
import se1app.applicationcore.officecomponent.OfficeRepository;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by abw286 on 06.12.2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(classes = Application.class)
@ActiveProfiles("test")
public class AccountRepositoryTest {

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    OfficeRepository officeRepository;

    private Account acc01, acc02;
    private Office office1, office2;

    @Before
    public void setUp() throws Exception {
        office1 = new Office(1);
        office2 = new Office(2);
        officeRepository.save(office1);
        officeRepository.save(office2);
        acc01 = new Account(1, office1);
        acc02 = new Account(2, office2);
        accountRepository.save(acc01);
        accountRepository.save(acc02);
    }

    @Test
    public void findAll() throws Exception {
        List<Account> accounts = accountRepository.findAll();
        assertThat(accounts).hasSize(2);
        assertThat(accounts).extracting(Account::getAccountNr).contains(1);
        assertThat(accounts).extracting(Account::getAccountNr).contains(2);
        assertThat(accounts).extracting(account -> account.getOffice().getNr()).contains(1);
        assertThat(accounts).extracting(account -> account.getOffice().getNr()).contains(2);
    }

    @Test
    public void findByAccountNrTest() throws Exception {
        Account account = accountRepository.findByAccountNr(1);
        assertThat(account).isEqualTo(acc01);
    }
}