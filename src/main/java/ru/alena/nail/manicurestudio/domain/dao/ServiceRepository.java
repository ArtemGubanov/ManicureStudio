package ru.alena.nail.manicurestudio.domain.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.alena.nail.manicurestudio.domain.entity.Service;

/**
 * Интерфейс репозитория услуг студии маникюра.
 * Для данного интерфейса атоматически во время выполнения создается имплементация в контейнере Спринга.
 *
 * @author Gubanov Artyom.
 */
public interface ServiceRepository extends JpaRepository<Service,Long> {
}
