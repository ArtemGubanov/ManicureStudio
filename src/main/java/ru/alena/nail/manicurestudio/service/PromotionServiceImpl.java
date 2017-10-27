package ru.alena.nail.manicurestudio.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.alena.nail.manicurestudio.domain.dao.PromotionRepository;
import ru.alena.nail.manicurestudio.domain.entity.Promotion;

import java.util.Date;
import java.util.List;

/**
 * Сервис для акциий, проводимых студией маниуюрв
 *
 * @author Gubanov Artyom.
 */
@Service
public class PromotionServiceImpl implements PromotionService {

    /**
     * Логгер
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(PromotionServiceImpl.class);

    /**
     * Репозиторий акций
     */
    @Autowired
    private PromotionRepository promotionRepository;

    @Override
    public Promotion getPromotion(Long id) {
        Promotion promotion = promotionRepository.findOne(id);
        if (promotion == null) {
            LOGGER.warn("Акция с id=" + id + "не найдена");
        }
        return promotion;
    }

    @Override
    public List<Promotion> getCurrentPromotions() {
        Date currentDate = new Date();
        System.out.println(currentDate);
        List<Promotion> currentPromotions = promotionRepository.findCurrentPromotions(currentDate);
        if (currentPromotions == null) {
            LOGGER.warn("В БД не найдено ни одной текущей акции");
        }
        return currentPromotions;
    }

    @Override
    public Promotion addPromotion(Promotion newPromotion) {
        return promotionRepository.saveAndFlush(newPromotion);
    }
}
