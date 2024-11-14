package com.workintech.ecomm.service;

import com.workintech.ecomm.entity.User;

public interface AuthenticationService {
    User register(String firstName, String lastName, String email, String password);
}