package ru.alena.nail.manicurestudio.domain.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.alena.nail.manicurestudio.domain.entity.User;

/**
 * Интерфейс репозитория  пользователей сайта
 * Для данного интерфейса атоматически во время выполнения создается имплементация в контейнере Спринга.
 *
 * @author Gubanov Artyom.
 */
public interface UserRepository extends JpaRepository<User, Long> {

    /**
     * Найти в БД пользователя по его имени пользователя (username)
     *
     * @param username имя пользователя
     * @return объект-сущность представляющий пользователя сайта
     */
    @Query("SELECT u FROM User u WHERE u.username = ?1")
    User findByUsername(String username);

}
