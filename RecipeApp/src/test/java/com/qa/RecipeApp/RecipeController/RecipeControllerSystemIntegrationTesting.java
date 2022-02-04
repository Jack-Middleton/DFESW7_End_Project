package com.qa.RecipeApp.RecipeController;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.RecipeApp.data.entity.RecipeBook;
import com.qa.RecipeApp.data.repository.Repository;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@Transactional
public class RecipeControllerSystemIntegrationTesting {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private Repository repo;

	// used to serialize and deserialize an object
	@Autowired
	private ObjectMapper objectMapper;

	private List<RecipeBook> databaseRecipes;
	private long newElement;

	@BeforeEach
	public void init() {
		// create a list of recipes to populate the DB
		List<RecipeBook> recipes = List.of(new RecipeBook(1L, "mac", "mac", "jack"),
				new RecipeBook(2L, "fish", "fish", "jack"), new RecipeBook(3L, "Ham", "Ham", "Jack"));
		// set databaseRecipes equal to a new array list
		databaseRecipes = new ArrayList<>();
		// save recipes to databaseRecipes, essentially creating a mock DB
		databaseRecipes.addAll(repo.saveAll(recipes));
		int size = databaseRecipes.size();
		newElement = databaseRecipes.get(size - 1).getId() + 1;

	}

	@Test
	public void getAllTest() throws Exception {

		// create a mock request, specifying the path as outlined in the controller
		// class
		MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.request(HttpMethod.GET, "/recipe/getAll");

		// specify that it accepts an expected returned content type of application/json
		mockRequest.accept(MediaType.APPLICATION_JSON);

		// use object mapper to create an expected Json string
		String recipes = objectMapper.writeValueAsString(databaseRecipes);

		// setup resultMatchers
		// so that we can compare our mockRequest with our
		// specified values

		ResultMatcher statusMatcher = MockMvcResultMatchers.status().isOk();
		ResultMatcher contentMatcher = MockMvcResultMatchers.content().json(recipes);

		// perform the mock request and expect the results to be equal to statusMatcher
		// and contentMatcher
		mockMvc.perform(mockRequest).andExpect(statusMatcher).andExpect(contentMatcher);

	}

	@Test
	public void createRecipeTest() throws Exception {
		RecipeBook newRecipe = new RecipeBook("mac", "mac", "jack");
		RecipeBook expectedRecipe = new RecipeBook(newElement, newRecipe.getRecipeName(), newRecipe.getRecipeDetails(),
				newRecipe.getAuthor());

		MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.request(HttpMethod.POST, "/recipe/add");

		mockRequest.contentType(MediaType.APPLICATION_JSON);

		mockRequest.content(objectMapper.writeValueAsString(newRecipe));

		mockRequest.accept(MediaType.APPLICATION_JSON);

		ResultMatcher statusMatcher = MockMvcResultMatchers.status().isCreated();
		ResultMatcher contentMatcher = MockMvcResultMatchers.content()
				.json(objectMapper.writeValueAsString(expectedRecipe));

		mockMvc.perform(mockRequest).andExpect(statusMatcher).andExpect(contentMatcher);

	}

	@Test
	public void getByIdTest() throws Exception {
		Long id = databaseRecipes.get(0).getId();

		MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.request(HttpMethod.GET, "/recipe/get/" + id);
		mockRequest.accept(MediaType.APPLICATION_JSON);
		mockRequest.contentType(MediaType.APPLICATION_JSON);
		mockRequest.content(objectMapper.writeValueAsString(databaseRecipes));

		ResultMatcher statusMatcher = MockMvcResultMatchers.status().isOk();

		mockMvc.perform(mockRequest).andExpect(statusMatcher);
	}

	@Test
	public void deleteTest() throws Exception {
		long id = databaseRecipes.get(0).getId();

		MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.request(HttpMethod.DELETE,
				"/recipe/delete/" + id);
		mockRequest.accept(MediaType.APPLICATION_JSON);
		mockRequest.contentType(MediaType.APPLICATION_JSON);
		mockRequest.content(objectMapper.writeValueAsString(databaseRecipes));

		ResultMatcher statusMatcher = MockMvcResultMatchers.status().isOk();

		mockMvc.perform(mockRequest).andExpect(statusMatcher);
	}

	@Test
	public void updateTest() throws Exception {

		Long id = databaseRecipes.get(0).getId();
		RecipeBook newRecipe = new RecipeBook("mac", "mac", "jack");
		RecipeBook expectedRecipe = new RecipeBook(id, "mac", "mac", "jack");

		MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.request(HttpMethod.PUT,
				"/recipe/update/" + id);
		mockRequest.contentType(MediaType.APPLICATION_JSON);
		mockRequest.content(objectMapper.writeValueAsString(newRecipe));
		mockRequest.accept(MediaType.APPLICATION_JSON);
		String recipeJson = objectMapper.writeValueAsString(expectedRecipe);

		ResultMatcher statusMatcher = MockMvcResultMatchers.status().isAccepted();
		ResultMatcher contentMatcher = MockMvcResultMatchers.content().json(recipeJson);

		mockMvc.perform(mockRequest).andExpect(statusMatcher).andExpect(contentMatcher);

	}

}
