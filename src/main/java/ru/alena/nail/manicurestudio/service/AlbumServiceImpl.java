package ru.alena.nail.manicurestudio.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.alena.nail.manicurestudio.domain.dao.AlbumRepository;
import ru.alena.nail.manicurestudio.domain.entity.Album;

import java.util.List;

/**
 * Сервис для альбомов, представленных на сайте студии маникюра
 *
 * @author Gubanov Artyom.
 */
@Service
public class AlbumServiceImpl implements AlbumService {

    /**
     * Логгер
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(AlbumServiceImpl.class);

    /**
     * Репозиторий альбомов
     */
    @Autowired
    private AlbumRepository albumRepository;


    @Override
    public Album getAlbum(Long id) {
        Album album = albumRepository.findOne(id);
        if (album == null) {
            LOGGER.warn("Альбом с id=" + id + "не найден");
        }
        return album;
    }

    @Override
    public List<Album> getAllAlbums() {
        List<Album> albums = albumRepository.findAll();
        if (albums == null) {
            LOGGER.warn("В БД не найдено ни одного альбома");
        }
        return albums;
    }
}
