package ru.alena.nail.manicurestudio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.alena.nail.manicurestudio.domain.dao.RoleRepository;
import ru.alena.nail.manicurestudio.domain.dao.UserRepository;
import ru.alena.nail.manicurestudio.domain.entity.Role;
import ru.alena.nail.manicurestudio.domain.entity.RoleName;
import ru.alena.nail.manicurestudio.domain.entity.User;

import java.util.HashSet;
import java.util.Set;

/**
 * Сервис для пользователей сайта
 *
 * @author Gubanov Artyom.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void saveService(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        // Установим для данного пользователя одну роль - 'USER'
        Set<Role> roles = new HashSet<>();
        roles.add(roleRepository.findByRoleName(RoleName.USER));
        user.setRoles(roles);
        userRepository.saveAndFlush(user);
    }

    @Override
    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
