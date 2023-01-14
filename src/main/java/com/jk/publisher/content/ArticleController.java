package com.jk.publisher.content;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jk.publisher.authentication.User;

@CrossOrigin
@RestController
@RequestMapping("/article")
public class ArticleController {
	private static final String ALL = "all";
	private static final  String TITLE = "title";
	private static final String CONTENT = "content";
	private static final String READ_TIME = "read-time";

	@Autowired
	private final ArticleRepository repository;

	public ArticleController(ArticleRepository repository) {
		this.repository = repository;
	}

	@RequestMapping(value = "/list")
	public List<Article> getArticles(String category) {
		return repository.findAll();
	}

	@RequestMapping(value = "/categories")
	public List<String> getCategoryNames() {
		return repository.listCategories();
	}

	@PostMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Integer saveArticle(@RequestParam String operation, @RequestBody Article article) {

		if (operation.equals(ALL)) {
			repository.save(article);
			
		} else if (!article.getId().equals(null)) {
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
