package com.workintech.ecomm.service;

import com.workintech.ecomm.entity.Role;
import com.workintech.ecomm.entity.User;
import com.workintech.ecomm.exceptions.EcommException;
import com.workintech.ecomm.repository.RoleRepository;
import com.workintech.ecomm.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    public User register(String firstName, String lastName, String email, String password){
        String encodedPassword = passwordEncoder.encode(password);
        Role userRole = roleRepository.findByAuthority("USER")
                .orElseThrow(() -> new EcommException("Role USER not found", HttpStatus.NOT_FOUND));

        Set<Role> roles = new HashSet<>();
        roles.add(userRole);

        User user = new User();

        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(email);
        user.setPassword(encodedPassword);
        user.setAuthorities(roles);

        return userRepository.save(user);
    }
}
