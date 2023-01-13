package com.jk.publisher.content;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;

@Entity
@Table(name="ARTICLE", schema="ARTICLES")
public class Article {
	@Id
	public String Id;
	public String title;
	public String content;
	public String footerContent;
	public String imageURL;
	public int readTime;
	
}
