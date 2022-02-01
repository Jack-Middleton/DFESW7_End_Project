package com.qa.RecipeApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.RecipeApp.data.entity.RecipeBook;
import com.qa.RecipeApp.data.repository.Repository;
import com.qa.RecipeApp.exceptions.RecipeNotFoundException;

@Service
public class RecipeService {

	private Repository repository;

	@Autowired // dependency injection
	public RecipeService(Repository repository) {
		this.repository = repository;
	}

	public List<RecipeBook> getAll() {
		return repository.findAll();
	}

	public RecipeBook addItem(RecipeBook recipeBook) {
		return this.repository.save(recipeBook);
	}

	public RecipeBook deleteById(long id) {
		if (this.repository.existsById(id)) {
			this.repository.deleteById(id);
		}
		return null;
	}

	public RecipeBook updateById(long id, RecipeBook recipeBook) {
		if (this.repository.existsById(id)) {
			RecipeBook recipeExists = this.repository.getById(id);
			recipeExists.setAuthor(recipeBook.getAuthor());
			recipeExists.setRecipeDetails(recipeBook.getRecipeDetails());
			recipeExists.setRecipeName(recipeBook.getRecipeName());
			return this.repository.save(recipeExists);
		} else {
			throw new RecipeNotFoundException("Recipe with id " + id + " not found");
		}
	}

	public RecipeBook getById(long id) {
		if (this.repository.existsById(id)) {
			return this.repository.findById(id).get();
		}

		else {
			// Custom exception
			throw new RecipeNotFoundException("Recipe with id " + id + " not found");
		}

	}

}
