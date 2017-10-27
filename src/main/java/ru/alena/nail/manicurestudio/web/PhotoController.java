package ru.alena.nail.manicurestudio.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.alena.nail.manicurestudio.domain.entity.Photo;
import ru.alena.nail.manicurestudio.service.AlbumService;
import ru.alena.nail.manicurestudio.service.PhotoService;

import java.util.List;

/**
 * Контроллер для фотографий
 *
 * @author Gubanov Artyom.
 */
@Controller
@RequestMapping(value = "/photos")
public class PhotoController {

    /**
     * Сервиса для фотографий, представленных в галереи на сайте студии маникюра
     */
    @Autowired
    private PhotoService photoService;

    /**
     * Сервиса для альбомов фотографий, представленных в галереи на сайте студии маникюра
     */
    @Autowired
    private AlbumService albumService;

    /**
     * Контроллер обрабатывающий запрос на получени стрницы с галереей фотографий
     *
     * @param model модель
     * @return именование html представления, отображающего результат запроса
     */
    @RequestMapping(method = RequestMethod.GET)
    public String getPhoto(Model model) {
        List<Photo> photos = photoService.getAllPhotos();
        Photo currentPhoto = photos.get(0);
        model.addAttribute("currentPhoto", currentPhoto);
        return "photoGallery";
    }


    /**
     * Контроллер обрабатывающий запрос на получения следующей фотографии в галлереи
     *
     * @param currentPhotoId текущая фотографиия, окрытой в галереи
     * @param model          моедль
     * @return наименование html представления, отображающего результат запроса
     */
    @RequestMapping(value = "/{currentPhotoId}/nextPhoto", method = RequestMethod.GET)
    public String nextPhoto(@PathVariable("currentPhotoId") Long currentPhotoId, Model model) {
        List<Photo> photos = photoService.getAllPhotos();
        Photo currentPhoto = photoService.getPhoto(currentPhotoId);
        int currentPhotoListIndex = photos.indexOf(currentPhoto);
        Photo nextPhoto = photos.get((currentPhotoListIndex < (photos.size() - 1)) ? ++currentPhotoListIndex :
                currentPhotoListIndex);
        model.addAttribute("currentPhoto", nextPhoto);
        return "photoGallery";
    }

    /**
     * Контроллер обрабатывающий запрос на получения предыдущей фотографии в галлереи
     *
     * @param currentPhotoId текущая фотографиия, окрытой в галереи
     * @param model          моедль
     * @return наименование html представления, отображающего результат запроса
     */
    @RequestMapping(value = "/{currentPhotoId}/prevPhoto", method = RequestMethod.GET)
    public String prevPhoto(@PathVariable("currentPhotoId") Long currentPhotoId, Model model) {
        List<Photo> photos = photoService.getAllPhotos();
        Photo currentPhoto = photoService.getPhoto(currentPhotoId);
        int currentPhotoListIndex = photos.indexOf(currentPhoto);
        Photo prevPhoto = photos.get((currentPhotoListIndex > 0) ? --currentPhotoListIndex :
                currentPhotoListIndex);
        model.addAttribute("currentPhoto", prevPhoto);
        return "photoGallery";
    }

}
