package ru.alena.nail.manicurestudio.domain.entity;

import javax.persistence.*;
import java.util.Set;

/**
 * @author Gubanov Artyom.
 */
@Entity
@Table(name = "\"user\"")
public class User extends DBObject {

    /**
     * Уникальный идентификатор пользователя сайта
     */
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_id_seq")
    @SequenceGenerator(name = "user_id_seq", sequenceName = "user_id_seq", allocationSize = 1)
    private Long id;

    /**
     * Имя пользователя
     */
    @Column(name = "username")
    private String username;

    /**
     * Пароль пользователя
     */
    @Column(name = "password")
    private  String password;

    /**
     * Подтверждение пароля.
     * Используется только во время регистрации нового пользователя.
     * Данное поле в БД не записывается.
     */
    @Transient
    transient private String confirmPassword;

    @ManyToMany
    @JoinTable(name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", confirmPassword='" + confirmPassword + '\'' +
                ", roles=" + roles +
                '}';
    }

}
