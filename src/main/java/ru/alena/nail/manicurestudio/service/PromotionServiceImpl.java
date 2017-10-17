package ru.alena.nail.manicurestudio.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.alena.nail.manicurestudio.domain.dao.PromotionRepository;
import ru.alena.nail.manicurestudio.domain.entity.Promotion;

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
    public List<Promotion> getAllPromotions() {
        List<Promotion> promotions = promotionRepository.findAll();
        if (promotions == null) {
            LOGGER.warn("В БД не найдено ни одной акции");
        }
        return promotions;
    }

    @Override
    public Promotion addPromotion(Promotion newPromotion) {
        return promotionRepository.saveAndFlush(newPromotion);
    }
}
