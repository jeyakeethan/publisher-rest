package com.jk.publisher.authentication;

import java.util.Arrays;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class UserController {

	@Autowired
	private final UserRepository repository;

	public UserController(UserRepository repository) {
		this.repository = repository;
	}
	
	@PostMapping(value = "/login", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public User login(@RequestBody User userObj) {
		
		Optional<User> user = repository.findByUsername(userObj.getUsername());
		if (user.isPresent() && user.get().getEncryptedPassword().equals(userObj.getPassword())) {
			user.get().setAuthenticationToken(new AuthenticationToken(Arrays.asList("Dashboard", "ReadContent", "ReadPremiumContent")));
			return user.get();
		}
		return null;
	}

}
