package com.qa.RecipeApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.RecipeApp.data.entity.RecipeBook;
import com.qa.RecipeApp.data.repository.Repository;

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

}