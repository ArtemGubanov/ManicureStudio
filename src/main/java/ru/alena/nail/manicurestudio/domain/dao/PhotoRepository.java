package ru.alena.nail.manicurestudio.domain.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.alena.nail.manicurestudio.domain.entity.Photo;

/**
 * Интерфейс репозитория фотографий, размещенных на сайте студии маникюра.
 * Для данного интерфейса атоматически во время выполнения создается имплементация в контейнере Спринга.
 *
 * @author Gubanov Artyom.
 */
public interface PhotoRepository extends JpaRepository<Photo, Long> {
}
