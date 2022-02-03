package com.qa.RecipeApp.RecipeService;

import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.qa.RecipeApp.data.entity.RecipeBook;
import com.qa.RecipeApp.data.repository.Repository;
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
	void testCreate() {
		// GIVEN
		final RecipeBook NEW_RECIPE = new RecipeBook(null, "Mac", "Mac", "Jack");
		final RecipeBook SAVED_RECIPE = new RecipeBook(1l, "Mac", "Mac", "Jack");

		// WHEN
		Mockito.when(this.repo.save(NEW_RECIPE)).thenReturn(SAVED_RECIPE);

		// THEN
		Assertions.assertThat(this.service.addItem(NEW_RECIPE)).isEqualTo(SAVED_RECIPE);

		// verify that our repo was accessed exactly once
		verify(this.repo, Mockito.times(1)).save(NEW_RECIPE);

	}

	@Test
	void testGetAll() {
		// WHEN
		Mockito.when(this.repo.findAll()).thenReturn(recipes);

		// THEN
		Assertions.assertThat(this.service.getAll()).isEqualTo(recipes);

		// verify
		verify(this.repo, Mockito.times(1)).findAll();

	}

	@Test
	void testDelete() {
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
	void testGetById() {
		long id = expectedRecipeWithID.getId();
		// WHEN
		Mockito.when(this.repo.findById(id)).thenReturn(Optional.of(expectedRecipeWithID));

		// THEN
		Assertions.assertThat(this.service.getById(id)).isEqualTo(expectedRecipeWithID);

		// verify
		verify(repo).findById(id);

	}

}
