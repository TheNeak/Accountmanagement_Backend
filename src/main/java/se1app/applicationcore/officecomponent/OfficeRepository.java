package se1app.applicationcore.officecomponent;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Neak on 03.12.2016.
 */
@Repository
public interface OfficeRepository extends JpaRepository<Office, Integer> {
    Office findByNr(Integer nr);
}
