package com.qa.RecipeApp.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.qa.RecipeApp.data.entity.RecipeBook;
import com.qa.RecipeApp.service.RecipeService;

@RestController
@RequestMapping(path = "/recipe")
public class RecipeController {

	private RecipeService RecipeService;

	@Autowired
	public RecipeController(RecipeService recipeService) {
		this.RecipeService = recipeService;
	}

	// read all items in the database
	@GetMapping
	public ResponseEntity<List<RecipeBook>> readAll() {
		ResponseEntity<List<RecipeBook>> authors = ResponseEntity.ok(RecipeService.getAll());
		return authors;
	}

	@GetMapping("/{id}")
	public ResponseEntity<RecipeBook> getById(@PathVariable("id") long id) {

		ResponseEntity<RecipeBook> recipe = ResponseEntity.status(200).body(RecipeService.getById(id));
		return recipe;
	}

	// post method to add items to the database
	@PostMapping
	public ResponseEntity<RecipeBook> addRecipe(@Valid @RequestBody RecipeBook recipeBook) {

		// builder design pattern
		ResponseEntity<RecipeBook> recipes = ResponseEntity.status(201).body(RecipeService.addItem(recipeBook));

		return recipes;
	}

	@DeleteMapping("/{id}")
	@ResponseBody
	public ResponseEntity<RecipeBook> deleteByID(@PathVariable("id") long id) {
		ResponseEntity<RecipeBook> recipes = ResponseEntity.status(200).body(RecipeService.deleteById(id));
		return recipes;

	}

	@PutMapping("/{id}")
	@ResponseBody
	public ResponseEntity<RecipeBook> updateByID(@PathVariable("id") long id, RecipeBook recipeBook) throws Exception {
		RecipeBook updatedRecipe = RecipeService.updateById(id, recipeBook);
		return new ResponseEntity<RecipeBook>(updatedRecipe, HttpStatus.ACCEPTED);
	}

}
