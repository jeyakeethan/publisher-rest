package com.jk.publisher.authentication;

import java.util.Arrays;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private final UserRepository repository;

	public UserController(UserRepository repository) {
		this.repository = repository;
	}

	@PostMapping(value = "/signup", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public User signup(@RequestBody User user) throws FailToUpdateDBException {
		if ((user.getUsername() != null) && (user.getEmail() != null)
			&& (user.getFirstName() != null) && (user.getLastName() != null)
		    && (user.getPassword() != null) && (user.getCountry() != null)) {
			
			Optional<User> userX = repository.findByUsernameOrEmail(user.getUsername(), user.getEmail());
			if(userX.isPresent()) {
				throw new FailToUpdateDBException("A user with the username or email you provided already exists."
						+ " Try with another username and email.");
			}
			return repository.save(user);
		}
		throw new FailToUpdateDBException("Something got wrong."
				+ "Unable to create the user record, please try again later.");
	}
	
	@PostMapping(value = "/login", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public User login(@RequestBody User userObj) throws UserNotFoundException {
		
		Optional<User> user = repository.findByUsername(userObj.getUsername());
		if (user.isPresent() && user.get().getEncryptedPassword().equals(userObj.getPassword())) {
			user.get().setAuthenticationToken(new AuthenticationToken(Arrays.asList("Dashboard", "ReadContent", "ReadPremiumContent")));
			return user.get();
		}
		
		throw new UserNotFoundException("Please check with the credetials. No maching user found for the user "
		+ userObj.getUsername() + "and the password you entered.");
	}

}
