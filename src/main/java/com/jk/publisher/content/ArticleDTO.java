package com.jk.publisher.content;

public class ArticleDTO {

	private Long id;
	private String title;
	private String content;
	private String author;
	private String footerContent;
	private String imageURL;
	private int readTime;

	public ArticleDTO(Article article) {
		this.setId(article.getId());
		this.setTitle(article.getTitle());
		this.setContent(article.getContent());
		this.setFooterContent(article.getFooterContent());
		this.setImageURL(article.getImageURL());
		this.setReadTime(article.getReadTime());
		this.setAuthor(article.getAuthor());
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
}
