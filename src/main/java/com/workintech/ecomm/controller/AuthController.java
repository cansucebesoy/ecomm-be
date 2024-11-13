package com.workintech.ecomm.controller;

import com.workintech.ecomm.dto.UserDTO;
import com.workintech.ecomm.entity.User;
import com.workintech.ecomm.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {

    private final AuthenticationService authenticationService;

    @PostMapping("/register") //UserDTO dondur
    public User register(@RequestBody UserDTO userDTO){
        return authenticationService
                .register(userDTO.getFirstName(), userDTO.getLastName(), userDTO.getEmail(), userDTO.getPassword());
    }
}
