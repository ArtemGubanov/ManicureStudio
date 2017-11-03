package ru.alena.nail.manicurestudio.service;

import ru.alena.nail.manicurestudio.domain.entity.User;

/**
 * Интерфейс сервиса для пользователей сайта
 *
 * @author Gubanov Artyom.
 */
public interface UserService {

    /**
     * Сохранить пользователя
     *
     * @param user новый или обновленный пользователь сайта
     */
    void  saveUser(User user);

    /**
     * Получить пользователя по его username
     *
     * @param username имя пользователя
     * @return пользователь
     */
    User getUserByUsername(String username);

}
