package ru.alena.nail.manicurestudio.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.alena.nail.manicurestudio.domain.entity.Service;
import ru.alena.nail.manicurestudio.service.ServiceService;

import java.util.List;

/**
 * Контроллер для услуг, предостовляемых студией маникюра
 *
 * @author Gubanov Artyom.
 */
@Controller
@RequestMapping(value = "/services")
public class ServiceController {

    /**
     * Сервис для услуг
     */
    @Autowired
    private ServiceService serviceService;

    /**
     * Получить все услуги
     *
     * @return название предсталения отоборажающего список всех, предоставляемых услуг
     */
    @RequestMapping(method = RequestMethod.GET)
    public String allServices(Model model) {
        List<Service> allServices = serviceService.getAllServices();
        model.addAttribute("allServices", allServices);
        return "serviceList";
    }



}
