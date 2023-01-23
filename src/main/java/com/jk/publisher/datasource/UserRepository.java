package com.jk.publisher.datasource;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jk.publisher.authentication.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	Optional<User> findByEmail(String email);
	Optional<User> findByUsernameOrEmail(String username, String email);
	Optional<User> findByUsername(String username);
    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);
	User save(User user);
}

