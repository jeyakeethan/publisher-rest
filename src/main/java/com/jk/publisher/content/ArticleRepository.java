package com.jk.publisher.content;

import java.util.List;
import java.util.Optional;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

public interface ArticleRepository extends JpaRepository<Article, Long> {
	
	public Optional<Article> findById(String id);
	public List<Article> findByCategory(String category);
	public Article save(Article article);
	
	@Query("SELECT DISTINCT category FROM Article articles")
	List<String> listCategories();
}

