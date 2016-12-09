package se1app.applicationcore.bankaccount_component;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Neak on 09.12.2016.
 */
@Repository
public interface BookingPositionRepository extends JpaRepository<BookingPosition, Integer> {
}
