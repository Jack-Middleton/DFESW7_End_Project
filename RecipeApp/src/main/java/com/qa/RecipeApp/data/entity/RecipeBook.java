package com.qa.RecipeApp.data.entity;

import java.util.Objects;

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

	@Override
	public int hashCode() {
		return Objects.hash(author, id, recipeDetails, recipeName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RecipeBook other = (RecipeBook) obj;
		return Objects.equals(author, other.author) && Objects.equals(id, other.id)
				&& Objects.equals(recipeDetails, other.recipeDetails) && Objects.equals(recipeName, other.recipeName);
	}

}
