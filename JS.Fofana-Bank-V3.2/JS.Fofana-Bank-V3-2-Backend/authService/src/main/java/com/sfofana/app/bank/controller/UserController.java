package com.sfofana.app.bank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sfofana.app.bank.model.User;
import com.sfofana.app.bank.service.UserService;

@RestController
@CrossOrigin
public class UserController {

	@Autowired
	UserService userService;
	
	@PostMapping("/api/v1/user")
	public User authenticstion(@RequestBody User user) {
		return userService.authenticate(user);
	}
	
//	@GetMapping("/api/v1/user")
//	public List<User> getAll() {
//		return userService.getUsers();
//	}
	
	@GetMapping("/api/v1/user")
	public User get() {
		return userService.getUser();
	}
}
