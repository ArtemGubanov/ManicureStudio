package ru.alena.nail.manicurestudio.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.alena.nail.manicurestudio.domain.dao.PhotoRepository;
import ru.alena.nail.manicurestudio.domain.entity.Photo;

import java.util.List;

/**
 * Сервис для фотографий, представленных на сайте студии маникюра
 *
 * @author Gubanov Artyom.
 */
@Service
public class PhotoServiceImpl implements PhotoService {

    /**
     * Логгер
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(PhotoServiceImpl.class);

    /**
     * Репозиторий фотографий
     */
    @Autowired
    private PhotoRepository photoRepository;


    @Override
    public Photo getPhoto(Long id) {
        Photo photo = photoRepository.findOne(id);
        if (photo == null) {
            LOGGER.warn("Фотография с id=" + id + "не найдена");
        }
        return photo;
    }

    @Override
    public List<Photo> getAllPhotos() {
        List<Photo> photos = photoRepository.findAll();
        if (photos == null) {
            LOGGER.warn("В БД не найдено ни одной фотографии");
        }
        return photos;
    }

}
