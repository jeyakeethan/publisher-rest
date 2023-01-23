package com.jk.publisher.datasource;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jk.publisher.content.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

	public Optional<Category> findById(Long id);

	public Optional<Category> findByCategory(String category);
	public Category save(Category category);

}

