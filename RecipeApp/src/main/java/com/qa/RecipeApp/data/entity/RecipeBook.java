package com.qa.RecipeApp.data.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

@Entity
public class RecipeBook {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@Length(min = 1, message = "Recipe names cannot be empty")
	private String recipeName;

	@NotNull
	private String recipeDetails;

	@NotNull
	@Length(min = 1, message = "Names cannot be empty")
	private String author;

	public RecipeBook() {
		super();
	}

	public RecipeBook(Long id, String recipeName, String recipeDetails, String author) {
		super();
		this.id = id;
		this.recipeName = recipeName;
		this.recipeDetails = recipeDetails;
		this.author = author;
	}

	public RecipeBook(String recipeName, String recipeDetails, String author) {
		super();
		this.recipeName = recipeName;
		this.recipeDetails = recipeDetails;
		this.author = author;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRecipeName() {
		return recipeName;
	}

	public void setRecipeName(String recipeName) {
		this.recipeName = recipeName;
	}

	public String getRecipeDetails() {
		return recipeDetails;
	}

	public void setRecipeDetails(String recipeDetails) {
		this.recipeDetails = recipeDetails;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

}
