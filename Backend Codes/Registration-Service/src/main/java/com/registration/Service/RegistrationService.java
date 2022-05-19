package com.registration.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.registration.Entity.User;
import com.registration.Repository.UserRepository;

@Service
public class RegistrationService {
	@Autowired
	private UserRepository repository;
	
	public String saveUser(User user) {
		repository.save(user);
		return "Hi "+user.getUsername() + " ,registration completed sucessfully";
	}
	
	public ResponseEntity<?> checkValidUser(User userData){
		User user=repository.findByUsername(userData.getUsername());
		
		if(user.getPassword().equals(userData.getPassword()))
		{
			return ResponseEntity.ok(user);
		}
		return (ResponseEntity<?>) ResponseEntity.internalServerError();
	}

}
