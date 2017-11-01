package ru.alena.nail.manicurestudio.domain.entity;

import javax.persistence.*;
import java.util.Set;

/**
 * Роль пользователя сайта
 *
 * @author Gubanov Artyom.
 */

@Entity
@Table(name = "role")
public class Role extends DBObject {

    /**
     * Уникальный идентификатор роли пользователя
     */
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "role_id_seq")
    @SequenceGenerator(name = "role_id_seq", sequenceName = "role_id_seq", allocationSize = 1)
    private Long id;

    /**
     * Имя роли
     */
    @Column(name = "name")
    @Enumerated(EnumType.STRING)
    private RoleName roleName;

    @ManyToMany(mappedBy = "roles")
    private Set<User> users;

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public RoleName getRoleName() {
        return roleName;
    }

    public void setRoleName(RoleName roleName) {
        this.roleName = roleName;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", roleName=" + roleName +
                ", users=" + users +
                '}';
    }
}
