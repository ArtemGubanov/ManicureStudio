package ru.alena.nail.manicurestudio.domain.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.alena.nail.manicurestudio.domain.entity.Promotion;

import java.util.Date;
import java.util.List;

/**

 *
 * @author Gubanov Artyom.
 */
public interface PromotionRepository extends JpaRepository<Promotion,Long> {

    @Query("SELECT p FROM Promotion p WHERE p.end_date >= ?1 and p.start_date <= ?1")
    List<Promotion> findCurrentPromotions(Date currentDate);
}
