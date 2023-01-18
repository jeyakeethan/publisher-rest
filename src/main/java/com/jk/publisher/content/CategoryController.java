package com.jk.publisher.content;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/category")
public class CategoryController {

	@Autowired
	private final CategoryRepository repository;

	public CategoryController(CategoryRepository repository) {
		this.repository = repository;
	}

	@RequestMapping(value = "/{category}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<ArticleDTO> getCategory(@PathVariable(required = false) String category) {

		Optional<Category> categoryObj = repository.findByCategory(category);
		if (categoryObj.isPresent()) {
			List<Article> articles = categoryObj.get().getArticles();
			List<ArticleDTO> articleDTOs = articles.stream().map((article)-> new ArticleDTO(article)).toList();
			return articleDTOs;
		}
		return null;
	}

	@RequestMapping(value = "/list", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<String> getCategories() {
		List<Category> categories = repository.findAll();
		List<String> strCategories = categories.stream().map((category)-> category.getCategory()).toList();
		return strCategories;
	}

	@PostMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Category saveCategory(@RequestBody Category category) {
		return repository.save(category);
	}
}
