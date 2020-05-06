package kz.iitu.mukhtar.electricity.service;


import kz.iitu.mukhtar.electricity.entity.Role;
import kz.iitu.mukhtar.electricity.entity.User;
import kz.iitu.mukhtar.electricity.exceptions.NoRoleException;
import kz.iitu.mukhtar.electricity.exceptions.UserNotFoundException;
import kz.iitu.mukhtar.electricity.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@AllArgsConstructor
@Component
public class UserService implements UserDetailsService {

    private UserRepository userRepository;
    private RoleRepository roleRepository;

    public User findUserById(Long id) throws UserNotFoundException {
        Optional<User> user = userRepository.findById(id);
        if (user == null) {
            throw new UserNotFoundException();
        }
        System.out.println(user);
        return user.orElseGet(null);
    }

    public List<User> showAllUsers() {
        return userRepository.findAll();
    }

    private boolean isUserExist(User user) {
        if (user == null) {
            System.out.println("Error, user does not exist");
            return false;
        } else
            return true;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);

        if (user == null)
            throw new UsernameNotFoundException("User with username: " + username + " is not found");

        return user;
    }


    public User saveUser(User user) {
        Set<Role> roles = new HashSet<>();
        Role userRole = roleRepository.findByName(user.getRole());
        System.out.println(userRole);
        if (userRole != null) {
            roles.add(userRole);
        } else
            throw new NoRoleException();
        user.setRoles(roles);
        user.setPassword(passwordEncoder().encode(user.getPassword()));
        return userRepository.save(user);
    }

    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
