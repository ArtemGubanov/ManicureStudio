package ru.alena.nail.manicurestudio.service;

import ru.alena.nail.manicurestudio.domain.entity.Photo;

import java.util.List;

/**
 * Интерфейс сервиса для фотографий, представленных в галереи на сайте студии маникюра
 *
 * @author Gubanov Artyom.
 */
public interface PhotoService {

    /**
     * Получить фотография по ее идентификатору
     *
     * @param id идентификатор фтотографии
     * @return фотография, соответствующая переданному идентификатору
     */
    Photo getPhoto(Long id);

    /**
     * Получить список всех фотографий
     *
     * @return список всех фотографий
     */
    List<Photo> getAllPhotos();

}
