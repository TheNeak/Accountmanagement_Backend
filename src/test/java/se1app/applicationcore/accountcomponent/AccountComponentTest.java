package se1app.applicationcore.accountcomponent;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import se1app.applicationcore.Application;

/**
 * Created by abw286 on 06.12.2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(classes = Application.class)
@ActiveProfiles("test")
public class AccountComponentTest {

    @Test
    public void getMoneyOfAccount() throws Exception {
        // TODO
    }

    @Test
    public void transferMoney() throws Exception {
        // TODO
    }

}