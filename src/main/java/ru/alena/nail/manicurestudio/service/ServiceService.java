package ru.alena.nail.manicurestudio.service;

import ru.alena.nail.manicurestudio.domain.entity.Service;

import java.util.List;

/**
 * Интерфейс сервиса для уклуг, предоставляемых студией манюкюра
 *
 * @author Gubanov Artyom.
 */
public interface ServiceService {

    /**
     * Получить услугу по ее идентификатору
     *
     * @param id идентификатор услуги
     * @return услуга, соответствующая переданному идентификатору
     */
    Service getService(Long id);

    /**
     * Получить список всех услуг
     *
     * @return список всех услуг
     */
    List<Service> getAllServices();

}
