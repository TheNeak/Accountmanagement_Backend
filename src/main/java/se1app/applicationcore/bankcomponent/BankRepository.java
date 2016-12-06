package se1app.applicationcore.bankcomponent;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Neak on 03.12.2016.
 */
@Repository
public interface BankRepository extends JpaRepository<Bank, Integer> {
    Bank findByNr(Integer nr);
}
