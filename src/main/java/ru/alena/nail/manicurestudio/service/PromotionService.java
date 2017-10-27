package ru.alena.nail.manicurestudio.service;

import ru.alena.nail.manicurestudio.domain.entity.Promotion;

import java.util.List;

/**
 * Интерфейс акции, проводимой студией маникюра
 *
 * @author Gubanov Artyom.
 */
public interface PromotionService {

    /**
     * Получить акцию по ее идентификатору
     *
     * @param id идентификатор акции
     * @return акция, соответствующая переданному идентификатору
     */
    Promotion getPromotion(Long id);

    /**
     * Получить список всех текущих акций
     *
     * @return список всех текущих акций
     */
    List<Promotion> getCurrentPromotions();

    /**
     * Добавить новую акции
     *
     * @param newPromotion новый объект-сущность, представляющий новую акциюю
     * @return объект-сущность, представляющий новую акциюю, сохраненный в БД
     */
    Promotion addPromotion(Promotion newPromotion);

}
