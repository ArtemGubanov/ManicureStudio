package ru.alena.nail.manicurestudio.domain.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.alena.nail.manicurestudio.domain.entity.Promotion;

/**

 *
 * @author Gubanov Artyom.
 */
public interface PromotionRepository extends JpaRepository<Promotion,Long> {
}
