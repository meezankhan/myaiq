package com.accenture.aiq.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.aiq.dto.LoginForm;
import com.accenture.aiq.dto.UserDTO;
import com.accenture.aiq.service.UserService;

@RestController
@RequestMapping()
public class LoginController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);

	@Autowired
	UserService userService;

	@PostMapping("/login")
	public UserDTO authenticateUser(@RequestBody LoginForm loginForm) {

		LOGGER.info("Login request received for email:{}", loginForm.getUserName());
		return userService.authenticateUser(loginForm);

	}
}
