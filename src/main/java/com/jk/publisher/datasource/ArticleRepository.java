package com.jk.publisher.datasource;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jk.publisher.content.Article;

public interface ArticleRepository extends JpaRepository<Article, Long> {

	public Optional<Article> findById(String id);

	public List<Article> findByCategory(String category);

	public Article save(Article article);

}
