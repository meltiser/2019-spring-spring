package com.epam.mvc.repository;

import com.epam.mvc.model.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
    List<User> getAllUsers();

    Optional<User> getUserById(Long id);
}
