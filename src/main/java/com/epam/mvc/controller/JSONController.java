package com.epam.mvc.controller;

import com.epam.mvc.model.Test;
import com.epam.mvc.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/test")
public class JSONController {

    @RequestMapping(value = "{name}", method = RequestMethod.GET)
    public @ResponseBody User getShopInJSON(@PathVariable String name) {

        User user = new User();
        user.setName(name);

        return user;
    }
}