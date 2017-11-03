package ru.alena.nail.manicurestudio.web;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import ru.alena.nail.manicurestudio.domain.entity.RoleName;

import java.util.Set;
import java.util.stream.Collectors;

/**
 * Контроллер, возвращающий точку входа в приложение.
 *
 * @author Gubanov Artyom.
 */
@Controller
@RequestMapping(value = "/")
public class MainController {

    @RequestMapping(method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public String getMainPage(Authentication authentication, Model model) {
        if (authentication == null){
            model.addAttribute("roleUser", null);
        } else {
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            Set<String> userRoles = authentication.getAuthorities().stream()
                    .map(authority -> authority.getAuthority()).collect(Collectors.toSet());
            if(userRoles.contains(RoleName.ADMIN.name())) {
                model.addAttribute("userRole",RoleName.ADMIN.name());
            } else if (userRoles.contains(RoleName.USER.name())) {
                model.addAttribute("userRole", RoleName.USER.name());
            }
        }
        return "index";
    }

}
