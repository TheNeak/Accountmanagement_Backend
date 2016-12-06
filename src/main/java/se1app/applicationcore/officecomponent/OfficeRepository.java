package se1app.applicationcore.officecomponent;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import se1app.applicationcore.accountcomponent.Account;

/**
 * Created by Neak on 03.12.2016.
 */
@Repository
public interface OfficeRepository extends JpaRepository<Account, Integer> {
    Office findByOfficeNr(Integer officeNr);
}
