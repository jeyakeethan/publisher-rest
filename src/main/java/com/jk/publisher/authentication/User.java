package com.jk.publisher.authentication;

import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.Size;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity(name="User")
@Table(name = "USERS", uniqueConstraints = {@UniqueConstraint(columnNames = {"email"})})
public class User {
	
	@Id
	@Column(length = 10)
    @Size(min = 20, max = 20)
	private String username;
	
	@Column(length = 64)
	private String password;
	
	@Column(length = 20)
	private String firstName;
	
	@Column(length = 20)
	private String lastName;
	
	@Column(length = 40)
	private String email;
	
	@Column(length = 250)
	private String about;

	@Column(length = 40)
	private String country;
	
	@Transient
	private AuthenticationToken authenticationToken;

	@Transient
	private long loginTimeMillis;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getEncryptedPassword() {
		return password;
	}

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}	
	
	public AuthenticationToken getAuthenticationToken() {
		return authenticationToken;
	}

	public void setAuthenticationToken(AuthenticationToken authenticationToken) {
		this.authenticationToken = authenticationToken;
	}

	public long getLoginTimeMillis() {
		return loginTimeMillis;
	}

	public void setLoginTimeMillis(long loginTimeMillis) {
		this.loginTimeMillis = loginTimeMillis;
	}
	
}
