package com.epam.mvc.repository;

import com.epam.mvc.model.User;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class UserRepositoryImplList implements UserRepository {
    private List<User> users = new ArrayList<>();

    public UserRepositoryImplList() {
        users.add(new User(1L, "Bob", LocalDate.of(1994, 12, 5)));
        users.add(new User(2L, "Tom", LocalDate.of(1991, 4, 9)));
        users.add(new User(3L, "John", LocalDate.of(1984, 5, 11)));
    }

    @Override
    public List<User> getAllUsers() {
        return users;
    }

    @Override
    public Optional<User> getUserById(Long id) {
        return users.stream()
                .filter(user -> id.equals(user.getId()))
                .findAny();
    }
}
