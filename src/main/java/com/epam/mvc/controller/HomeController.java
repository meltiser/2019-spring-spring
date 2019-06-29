package com.epam.mvc.controller;

import com.epam.mvc.model.Task;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/task")
public class HomeController {

	@GetMapping
	public Task displayWelcomeMessage() {
		Task task = new Task("123", "123");
		return task;
	}
}
