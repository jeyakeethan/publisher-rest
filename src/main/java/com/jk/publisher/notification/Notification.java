package com.jk.publisher.notification;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

import com.jk.publisher.authentication.User;
import com.jk.publisher.content.Article;

@Entity(name = "Notification")
@Table(name = "NOTIFICATIONS")
public class Notification {

	@Id
	private Long articleId;

	@Id
	@Column(length = 20)
	private String username;

	@Column(length = 20)
	private String status;

	@OneToOne
	@JoinColumn(name = "username")
	private User user;

	@OneToOne
	@JoinColumn(name = "articleId")
	private Article article;

	public Notification(Long articleId, String username) {
		this.articleId = articleId;
		this.username = username;
	}

	public Long getArticleId() {
		return articleId;
	}

	public void setArticleId(Long articleId) {
		this.articleId = articleId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

}
