package com.qa.RecipeApp.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.RecipeApp.data.entity.RecipeBook;
import com.qa.RecipeApp.service.RecipeService;

@RestController
@RequestMapping(path = "/recipe")
public class RecipeController {

	private RecipeService RecipeService;

	public RecipeController(RecipeService recipeService) {
		this.RecipeService = recipeService;
	}

	@GetMapping
	public ResponseEntity<List<RecipeBook>> readAll() {
		ResponseEntity<List<RecipeBook>> authors = ResponseEntity.ok(RecipeService.getAll());
		return authors;
	}

}
