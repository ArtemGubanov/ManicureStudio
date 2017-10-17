package ru.alena.nail.manicurestudio.service;

import ru.alena.nail.manicurestudio.domain.entity.Album;

import java.util.List;

/**
 * Интерфейс сервиса для альбомов, представленных на сайте студии маникюра
 *
 * @author Gubanov Artyom.
 */
public interface AlbumService {

    /**
     * Получить альбом по ее идентификатору
     *
     * @param id идентификатор альбома
     * @return альбом, соответствующий переданному идентификатору
     */
    Album getAlbum(Long id);

    /**
     * Получить список всех альбомов
     *
     * @return список всех альбомов
     */
    List<Album> getAllAlbums();

}
