package com.qa.RecipeApp.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

	// read all items in the database
	@GetMapping
	public ResponseEntity<List<RecipeBook>> readAll() {
		ResponseEntity<List<RecipeBook>> authors = ResponseEntity.ok(RecipeService.getAll());
		return authors;
	}

	@PostMapping
	public ResponseEntity<RecipeBook> addRecipe(@Valid @RequestBody RecipeBook recipeBook) {

		// builder design pattern
		ResponseEntity<RecipeBook> recipes = ResponseEntity.status(201).body(RecipeService.addItem(recipeBook));

		return recipes;
	}

}
