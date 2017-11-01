package ru.alena.nail.manicurestudio.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.alena.nail.manicurestudio.domain.dao.UserRepository;
import ru.alena.nail.manicurestudio.domain.entity.User;

import java.util.HashSet;
import java.util.Set;

/**
 * Интерфейс сервиса для получения данных пользователя
 *
 * @author Gubanov Artyom.
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    /**
     * Логгер
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(PromotionServiceImpl.class);

    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            LOGGER.warn("Пользователь \"{}\" не найден", username);
            throw new UsernameNotFoundException(username);
        }
        // список разрешений
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        user.getRoles().forEach(role -> grantedAuthorities.add(new SimpleGrantedAuthority(role.getRoleName().toString())));
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
                grantedAuthorities);
    }
}
