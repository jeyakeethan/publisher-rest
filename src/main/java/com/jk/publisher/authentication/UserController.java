package com.jk.publisher.authentication;

import java.util.Arrays;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RestController;

@Component
@RestController
public class UserController {

	@Autowired
	private final UserRepository repository;

	public UserController(UserRepository repository) {
		this.repository = repository;
	}
	
	@PostMapping("/login")
	public String login(@RequestAttribute String username, @RequestAttribute String password) {
		
		Optional<User> user = repository.findByUsername(username);
		if (user.isPresent() && user.get().getEncryptedPassword().equals(password)) {
			return new AuthenticationToken(Arrays.asList("Dashboard", "ReadContent", "ReadPremiumContent")).toString();
		}
		
		return null;
	}

}
