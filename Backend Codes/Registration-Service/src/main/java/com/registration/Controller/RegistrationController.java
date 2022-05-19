package com.registration.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.registration.Entity.User;
import com.registration.Service.RegistrationService;

@RestController
@CrossOrigin(origins="*")
@RequestMapping("/users")

public class RegistrationController {
	
	@Autowired
	private RegistrationService service;
	
	@PostMapping("/saveUser")
	public String saveUser(@RequestBody User user) {
		return service.saveUser(user);
	}
	@PostMapping("/checkValidity")
	
	public ResponseEntity<?> checkValidUser(@RequestBody User userData){
		return service.checkValidUser(userData);
	}
	

}
