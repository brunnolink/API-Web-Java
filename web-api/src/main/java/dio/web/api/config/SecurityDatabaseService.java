package dio.web.api.config;

import dio.web.api.model.Manager;
import dio.web.api.model.User;
import dio.web.api.repository.ManagerRepository;
import dio.web.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class SecurityDatabaseService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ManagerRepository managerRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Verificar se o usuário é um usuário normal
        User userEntity = userRepository.findByUsername(username);
        if (userEntity != null) {
            return buildUserDetails(userEntity);
        }

        // Verificar se o usuário é um gerente
        Manager managerEntity = managerRepository.findByUsername(username);
        if (managerEntity != null) {
            return buildUserDetails(managerEntity);
        }

        // Se o usuário não for encontrado
        throw new UsernameNotFoundException("Usuário não encontrado: " + username);
    }

    private UserDetails buildUserDetails(User user) {
        Set<GrantedAuthority> authorities = new HashSet<>();
        user.getRoles().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority("ROLE_" + role));
        });
        return new org.springframework.security.core.userdetails.User(
                user.getLogin(),
                user.getPassword(),
                authorities
        );
    }

    private UserDetails buildUserDetails(Manager manager) {
        Set<GrantedAuthority> authorities = new HashSet<>();
        manager.getRoles().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority("ROLE_" + role));
        });
        return new org.springframework.security.core.userdetails.User(
                manager.getLogin(),
                manager.getPassword(),
                authorities
        );
    }
}