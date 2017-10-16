package ru.alena.nail.manicurestudio.domain.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.alena.nail.manicurestudio.domain.entity.Album;

/**
 * Интерфейс репозитория альбомов фотографий, представленных на сайте студии маникюра.
 * Для данного интерфейса атоматически во время выполнения создается имплементация в контейнере Спринга.
 *
 * @author Gubanov Artyom.
 */
public interface AlbumRepository extends JpaRepository<Album, Long> {
}
