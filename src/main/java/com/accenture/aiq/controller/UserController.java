package com.accenture.aiq.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.aiq.dto.AuthenticateUserResponseDTO;
import com.accenture.aiq.dto.UserDTO;
import com.accenture.aiq.dto.DashboardFilterResponseDTO;
import com.accenture.aiq.service.UserService;

@RestController
public class UserController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

	@Autowired
	UserService userService;
	

	@PostMapping("/user/authenticate")
	public AuthenticateUserResponseDTO authenticate(@RequestBody UserDTO user) throws Exception{
		
		
		
		if(userService.isEmailAvailable(user.getUseremail())) {
			return userService.createResponse(user.getUseremail());
		}
		else {
			throw new Exception("User doesn't exist");
		}
	}
}
