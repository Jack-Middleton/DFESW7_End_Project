package com.qa.RecipeApp.RecipeService;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.qa.RecipeApp.data.entity.RecipeBook;
import com.qa.RecipeApp.data.repository.Repository;
import com.qa.RecipeApp.service.RecipeService;

@SpringBootTest
@Transactional
public class RecipeServiceIntegrationTesting {

	@Autowired
	private RecipeService service;

	@Autowired
	private Repository repo;

	private List<RecipeBook> databaseRecipes;
	private long newElementsId;

	@BeforeEach
	public void init() {
		// create a list of recipes to populate the DB
		List<RecipeBook> recipes = List.of(new RecipeBook(1L, "mac", "mac", "jack"),
				new RecipeBook(2L, "fish", "fish", "jack"), new RecipeBook(3L, "Ham", "Ham", "Jack"));
		// set databaseRecipes equal to a new array list
		databaseRecipes = new ArrayList<>();
		// save recipes to databaseRecipes, essentially creating a mock DB
		databaseRecipes.addAll(repo.saveAll(recipes));
		// the following sets a variable to the size of the db
		// and then sets a new variable to (size - 1) of the db to get the last element
		// and then get the new elements ID by getting the previous last elements ID and
		// adding 1
		// only works if you auto increment your ID's
		int size = databaseRecipes.size();
		newElementsId = databaseRecipes.get(size - 1).getId() + 1;

	}

	@Test
	public void getAllTest() {
		assertThat(databaseRecipes).isEqualTo(service.getAll());
	}

	@Test
	public void createItemTest() {
		RecipeBook newRecipe = new RecipeBook("mac", "mac", "Jack");
		RecipeBook expectedRecipe = new RecipeBook(newElementsId, newRecipe.getRecipeName(),
				newRecipe.getRecipeDetails(), newRecipe.getAuthor());

		assertThat(expectedRecipe).isEqualTo(service.addItem(newRecipe));

	}

	@Test
	public void getByIdTest() {
		RecipeBook getUser = databaseRecipes.get(1);
		assertThat(service.getById(getUser.getId())).isEqualTo(getUser);

	}

	@Test
	public void deleteTest() {
		RecipeBook getUser = databaseRecipes.get(1);
		long id = getUser.getId();

		service.deleteById(id);

		assertThat(repo.findById(id)).isEqualTo(Optional.empty());
	}

	@Test
	public void updateUserTest() {
		RecipeBook getUser = databaseRecipes.get(1);
		long id = getUser.getId();

		RecipeBook updatedRecipe = new RecipeBook(getUser.getId(), getUser.getAuthor() + "Middleton",
				getUser.getRecipeDetails(), getUser.getRecipeName());

		RecipeBook actual = service.updateById(id, updatedRecipe);
		assertThat(actual).isEqualTo(updatedRecipe);
	}
}
