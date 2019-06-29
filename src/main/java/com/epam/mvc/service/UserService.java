package com.epam.mvc.service;

import com.epam.mvc.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> getAllUsers();
    
    Optional<User> getUserById(Long id);
}
