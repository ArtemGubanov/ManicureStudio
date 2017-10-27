package ru.alena.nail.manicurestudio.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.alena.nail.manicurestudio.domain.entity.Promotion;
import ru.alena.nail.manicurestudio.service.PromotionService;

import java.util.List;

/**
 * Контроллер для акций, проводимых студией маникюра
 *
 * @author Gubanov Artyom.
 */
@Controller
@RequestMapping(value = "/promotions")
public class PromotionController {

    /**
     * Сервис для услуг
     */
    @Autowired
    private PromotionService promotionService;

    /**
     * Получить все текущие акции на услуги
     *
     * @return название предсталения отоборажающего список всех текущих акций на услуги
     */
    @RequestMapping(method = RequestMethod.GET)
    public String currentPromotions(Model model) {
        List<Promotion> currentPromotions = promotionService.getCurrentPromotions();
        model.addAttribute("currentPromotions", currentPromotions);
        return "promotions";
    }
}
