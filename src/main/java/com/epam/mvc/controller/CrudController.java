package com.epam.mvc.controller;

import com.epam.mvc.model.User;
import com.epam.mvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
public class CrudController {

    private final UserService userService;

    @Autowired
    public CrudController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    @ResponseBody
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/user/{id}")
    public User getUser(@PathVariable Long id, HttpServletRequest request) {
        Optional<User> userById = userService.getUserById(id);

        Cookie[] cookies = request.getCookies();
        boolean isCockiePresent = Arrays.stream(cookies)
                .anyMatch(cookie -> cookie.getValue().equals("kyka"));

        System.out.println(isCockiePresent);

        return userById.orElse(null);
    }

//    @GetMapping("/user/{id}")
//    @ResponseBody
//    public ResponseEntity<?> getUser(@PathVariable Long id) {
//        Optional<User> userById = userService.getUserById(id);
//        if (userById.isPresent()) {
//            return ResponseEntity.ok(userById.get());
//        }
//        return ResponseEntity.notFound().build();
//    }

//    @GetMapping("/users")
//    @ResponseBody
//    public List<User> getAllUsers() {
//        return userService.getAllUsers();
//    }
}
