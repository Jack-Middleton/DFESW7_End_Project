package com.qa.RecipeApp.RecipeService;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.qa.RecipeApp.data.entity.RecipeBook;
import com.qa.RecipeApp.data.repository.Repository;
import com.qa.RecipeApp.exceptions.RecipeNotFoundException;
import com.qa.RecipeApp.service.RecipeService;

@ExtendWith(MockitoExtension.class)
public class RecipeServiceUnitTesting {

	@InjectMocks
	private RecipeService service;

	@Mock
	Repository repo;

	private List<RecipeBook> recipes;
	private RecipeBook expectedRecipeWithID;
	private RecipeBook expectedRecipeWithoutID;

	@BeforeEach
	public void init() {
		recipes = new ArrayList<>();
		recipes.addAll(List.of(new RecipeBook(1L, "mac", "mac", "jack"), new RecipeBook(2L, "fish", "fish", "jack"),
				new RecipeBook(3L, "Ham", "Ham", "Jack")));

		expectedRecipeWithID = new RecipeBook(1L, "mac", "mac", "jack");
		expectedRecipeWithoutID = new RecipeBook("mac", "mac", "jack");
	}

	@Test
	public void testCreate() {
		// GIVEN
		final RecipeBook NEW_RECIPE = new RecipeBook(null, "Mac", "Mac", "Jack");
		final RecipeBook SAVED_RECIPE = new RecipeBook(1l, "Mac", "Mac", "Jack");

		// WHEN
		Mockito.when(this.repo.save(NEW_RECIPE)).thenReturn(SAVED_RECIPE);

		// THEN
		assertThat(this.service.addItem(NEW_RECIPE)).isEqualTo(SAVED_RECIPE);

		// verify that our repo was accessed exactly once
		verify(this.repo, Mockito.times(1)).save(NEW_RECIPE);

	}

	@Test
	public void testGetAll() {
		// WHEN
		Mockito.when(this.repo.findAll()).thenReturn(recipes);

		// THEN
		assertThat(this.service.getAll()).isEqualTo(recipes);

		// verify
		verify(this.repo, Mockito.times(1)).findAll();

	}

	@Test
	public void testDelete() {
		long id = expectedRecipeWithID.getId();
		// WHEN
		Mockito.when(this.repo.existsById(id)).thenReturn(true);

		// THEN
		service.deleteById(id);

		// verify
		verify(repo).existsById(id);
		verify(repo).deleteById(id);

	}

	@Test
	public void testGetById() {
		long id = expectedRecipeWithID.getId();
		// WHEN
		Mockito.when(this.repo.findById(id)).thenReturn(Optional.of(expectedRecipeWithID));

		// THEN
		assertThat(this.service.getById(id)).isEqualTo(expectedRecipeWithID);

		// verify
		verify(repo).findById(id);

	}

	@Test
	public void testUpdate() {
		long id = expectedRecipeWithID.getId();

		// mocking the updateById method body that updates the details of the recipe
		// entry
		RecipeBook updatedRecipe = new RecipeBook(expectedRecipeWithID.getId(),
				expectedRecipeWithID.getAuthor() + "Middleton", expectedRecipeWithID.getRecipeDetails(),
				expectedRecipeWithID.getRecipeName());
		// WHEN
		Mockito.when(repo.existsById(id)).thenReturn(true);
		Mockito.when(repo.getById(id)).thenReturn(expectedRecipeWithID);
		Mockito.when(repo.save(expectedRecipeWithID)).thenReturn(updatedRecipe);

		// THEN
		assertThat(this.service.updateById(id, updatedRecipe)).isEqualTo(updatedRecipe);

		// Verify
		verify(repo).existsById(id);
		verify(repo).getById(id);
		verify(repo).save(expectedRecipeWithID);

	}

	@Test
	public void deleteExceptionTest() {
		long id = 23456789;
		Mockito.when(repo.existsById(id)).thenReturn(false);

		RecipeNotFoundException x = Assertions.assertThrows(RecipeNotFoundException.class, () -> {
			service.deleteById(id);
		});

		String expected = "Recipe with id " + id + " not found";
		assertThat(x.getMessage()).isEqualTo(expected);
		verify(repo).existsById(id);

	}

	@Test
	public void updateExceptionTest() {
		long id = 98765;
		RecipeBook updatedRecipe = new RecipeBook(expectedRecipeWithID.getId(),
				expectedRecipeWithID.getAuthor() + "Middleton", expectedRecipeWithID.getRecipeDetails(),
				expectedRecipeWithID.getRecipeName());

		Mockito.when(repo.existsById(id)).thenReturn(false);

		RecipeNotFoundException x = Assertions.assertThrows(RecipeNotFoundException.class, () -> {
			service.updateById(id, expectedRecipeWithID);
		});

		String expected = "Recipe with id " + id + " not found";
		assertThat(x.getMessage()).isEqualTo(expected);
		verify(repo).existsById(id);

	}

	@Test
	public void getByIdTest() {
		long id = 746458498;

		Mockito.when(repo.findById(id)).thenReturn(Optional.empty());

		RecipeNotFoundException x = Assertions.assertThrows(RecipeNotFoundException.class, () -> {
			service.getById(id);
		});
		String expected = "Recipe with id " + id + " not found";
		assertThat(x.getMessage()).isEqualTo(expected);
		verify(repo).findById(id);

	}

}
