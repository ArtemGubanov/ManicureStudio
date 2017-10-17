package ru.alena.nail.manicurestudio.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import ru.alena.nail.manicurestudio.domain.dao.ServiceRepository;
import ru.alena.nail.manicurestudio.domain.entity.Service;

import java.util.List;

/**
 * Сервис для услуги, предоставляемых студией манюкюра
 *
 * @author Gubanov Artyom.
 */
@org.springframework.stereotype.Service
public class ServiceServiceImpl implements ServiceService {

    /**
     * Логгер
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(ServiceServiceImpl.class);

    /**
     * Репозиторий услуг
     */
    @Autowired
    private ServiceRepository serviceRepository;

    @Override
    public Service getService(Long id) {
        Service service = serviceRepository.findOne(id);
        if (service == null) {
            LOGGER.warn("Услуга с id=" + id + "не найдена");
        }
        return  service;

    }

    @Override
    public List<Service> getAllServices() {
        List<Service> services = serviceRepository.findAll();
        if (services == null) {
            LOGGER.warn("В БД не найдено ни одной услуги");
        }
        return services;
    }
}
