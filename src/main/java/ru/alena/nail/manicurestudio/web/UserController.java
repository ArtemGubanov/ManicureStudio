package ru.alena.nail.manicurestudio.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.alena.nail.manicurestudio.domain.entity.User;
import ru.alena.nail.manicurestudio.service.UserService;

/**
 * Контроллер пользоватлей сайта
 *
 * @author Gubanov Artyom.
 */
@Controller
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(User newUser, Model model) {
        return null;
    }

}
