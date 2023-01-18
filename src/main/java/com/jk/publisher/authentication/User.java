package com.jk.publisher.authentication;

import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.Size;

import java.util.List;
import java.util.Set;

import com.jk.publisher.content.Category;
import com.jk.publisher.notification.Notification;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapKeyColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity(name = "User")
@Table(name = "USERS", uniqueConstraints = { @UniqueConstraint(columnNames = { "email" }) })
public class User {

	@Id
	@Column(length = 20)
	@Size(min = 1, max = 20)
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

	@ManyToMany(cascade = { CascadeType.ALL })
	@JoinTable(name = "user_categories", joinColumns = { @JoinColumn(name = "username") }, inverseJoinColumns = {
			@JoinColumn(name = "categoryId") })
	private Set<Category> subscriptions;

	@OneToMany(cascade = CascadeType.REFRESH)
	@JoinColumn(name = "username")
	private Set<Notification> notifications;

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

	public Set<Notification> getNotifications() {
		return notifications;
	}

	public void setNotifications(Set<Notification> notifications) {
		this.notifications = notifications;
	}

	public Set<Category> getSubscriptions() {
		return subscriptions;
	}

	public void setSubscriptions(Set<Category> subscriptions) {
		this.subscriptions = subscriptions;
	}

}