package ru.alena.nail.manicurestudio.domain.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.alena.nail.manicurestudio.domain.entity.Role;
import ru.alena.nail.manicurestudio.domain.entity.RoleName;

/**
 * Интерфейс репозитория ролей пользователей сайта
 * Для данного интерфейса атоматически во время выполнения создается имплементация в контейнере Спринга.
 *
 * @author Gubanov Artyom.
 */
public interface RoleRepository extends JpaRepository<Role, Long> {

    /**
     * Найти роль пользователя по названию роли
     * @param roleName название роли пользователя
     * @return роль пользователя
     */
    @Query("SELECT r FROM Role r WHERE r.roleName = ?1")
    Role findByRoleName(RoleName roleName);

}
