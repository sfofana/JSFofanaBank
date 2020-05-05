package com.sfofana.app.bank.controller;

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
	public User accountInfo(@RequestBody User user) {
		return userService.getUser(user);
	}
	
	@GetMapping("/api/v1/user")
	public User httpGet() {
		return userService.getUsingHttp();
	}
}
