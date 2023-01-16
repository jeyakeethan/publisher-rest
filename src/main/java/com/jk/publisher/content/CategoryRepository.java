package com.jk.publisher.content;

import java.util.List;
import java.util.Optional;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

public interface CategoryRepository extends JpaRepository<Category, Long> {

	public Optional<Category> findById(Long id);
	public Optional<Category> findByCategory(String category);
	public Category save(Category category);

}

