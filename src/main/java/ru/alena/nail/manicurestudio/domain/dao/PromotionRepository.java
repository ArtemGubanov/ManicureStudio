package ru.alena.nail.manicurestudio.domain.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.alena.nail.manicurestudio.domain.entity.Promotion;

import java.util.Date;
import java.util.List;

/**
 * Интерфейс репозитория акций студии маникюра.
 * Для данного интерфейса атоматически во время выполнения создается имплементация в контейнере Спринга.
 *
 * @author Gubanov Artyom.
 */
public interface PromotionRepository extends JpaRepository<Promotion, Long> {

    /**
     * Найти В БД все действующие акции в данный период
     *
     * @param currentDate текущая дата
     * @return объект-сущность предсталяющий акцию
     */
    @Query("SELECT p FROM Promotion p WHERE p.end_date >= ?1 and p.start_date <= ?1")
    List<Promotion> findCurrentPromotions(Date currentDate);
}
