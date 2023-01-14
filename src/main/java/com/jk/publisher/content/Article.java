package com.jk.publisher.content;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.websocket.Decoder.Text;
import jakarta.persistence.Id;
@Entity
@Table(name="ARTICLES")
public class Article {

	@Id
	@Column(length = 10)
	public String id;
	@Column(length = 20)
	public String category;
	
	@Column(length = 100)	
	public String title;
	
	@Column(columnDefinition="TEXT")
	public String content;
	@Column(length = 250)
	public String footerContent;
	@Column(length = 100)
	public String imageURL;
	
	@Column
	public int readTime;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getFooterContent() {
		return footerContent;
	}

	public void setFooterContent(String footerContent) {
		this.footerContent = footerContent;
	}

	public String getImageURL() {
		return imageURL;
	}

	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}

	public int getReadTime() {
		return readTime;
	}

	public void setReadTime(int readTime) {
		this.readTime = readTime;
	}

}
