package ru.alena.nail.manicurestudio.web;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Контроллер для контактной информации
 *
 * @author Gubanov Artyom.
 */
@Controller
@RequestMapping(value = "/contacts")
public class ContactsController {

    @RequestMapping(method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public String getMainPage() {
        return "contacts";
    }

}
