package com.jk.publisher.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jk.publisher.content.Article;
import com.jk.publisher.content.ArticleDTO;
import com.jk.publisher.content.Category;
import com.jk.publisher.datasource.ArticleRepository;
import com.jk.publisher.datasource.CategoryRepository;

@CrossOrigin
@RestController
@RequestMapping("/article")
public class ArticleController {
	private static final String ALL = "";
	private static final String TITLE = "title";
	private static final String CONTENT = "content";
	private static final String READ_TIME = "read-time";

	@Autowired
	private final ArticleRepository repository;
	private final CategoryRepository categoryRepository;

	public ArticleController(ArticleRepository repository, CategoryRepository categoryRepository) {
		this.repository = repository;
		this.categoryRepository = categoryRepository;
	}

	@RequestMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Article getArticles(@RequestParam(name = "id") String id) {
		Optional<Article> article = repository.findById(id);
		return article.get();
	}

	@RequestMapping(value = "/list", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<ArticleDTO> getArticles() {
		List<Article> articles = repository.findAll();
		List<ArticleDTO> articleDTOs = articles.stream().map((article) -> new ArticleDTO(article)).toList();
		return articleDTOs;
	}

	@PostMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Integer saveArticle(@RequestParam String operation, @RequestBody Article article) throws Exception {
		Optional<Category> category = categoryRepository.findByCategory(article.getCategory().getCategory());
		if (!category.isPresent()) {
			throw new Exception("Unable to fulfil request at this time");
			// should throw appropriate exception
		}
		article.setCategory(category.get());
		if (operation.equals(ALL)) {
			repository.save(article);
		} else if (article.getId() != null) {
			Optional<Article> record = repository.findById(article.getId());

			if (operation.equals(TITLE)) {
				record.get().setTitle(article.getTitle());
			} else if (operation.equals(CONTENT)) {
				record.get().setContent(article.getContent());
			} else if (operation.equals(READ_TIME)) {
				record.get().setReadTime(article.getReadTime());
			}
			repository.save(record.get());

		} else {
			return -1;
		}
		return 0;
	}
}
