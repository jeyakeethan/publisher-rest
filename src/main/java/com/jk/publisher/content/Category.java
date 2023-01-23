package com.jk.publisher.content;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.annotation.Transient;

import com.jk.publisher.authentication.User;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name = "CATEGORIES", uniqueConstraints = { @UniqueConstraint(columnNames = { "category" }) })
public class Category implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(length = 20)
	private String category;

	@OneToMany
	@JoinColumn(name = "category")
	@Transient
	private List<Article> articles;

	@Transient
	@ManyToMany(mappedBy = "subscriptions", cascade = { CascadeType.ALL })
	private List<User> users;

	public Category () {}
	
		public Category (String category) {
		this.category = category;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public List<Article> getArticles() {
		return articles;
	}

	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}
}
