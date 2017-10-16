package ru.alena.nail.manicurestudio.domain.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.alena.nail.manicurestudio.domain.entity.Promotion;

/**
 * Интерфейс репозитория акций, проводимых студией маникюра.
 * Для данного интерфейса атоматически во время выполнения создается имплементация в контейнере Спринга.
 *
 * @author Gubanov Artyom.
 */
public interface PromotionRepository extends JpaRepository<Promotion,Long> {
}
