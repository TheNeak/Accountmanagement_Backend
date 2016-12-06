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

    private Account acc01;
    private Office office;


    @Before
    public void setUp() throws Exception {
        office = new Office(1);
        officeRepository.save(office);
        acc01 = new Account(1, office);
        accountRepository.save(acc01);
    }

    @Test
    public void findAll() throws Exception {
        accountRepository.findByAccountNr(1);
        List<Account> accounts = accountRepository.findAll();
        assertThat(accounts).hasSize(1);
        assertThat(accounts).extracting(Account::getAccountNr).contains(1);
        assertThat(accounts).extracting(account -> account.getOffice().getNr()).contains(1);
    }

}