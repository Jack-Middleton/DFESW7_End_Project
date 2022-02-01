package com.qa.RecipeApp.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qa.RecipeApp.data.entity.RecipeBook;

public interface Repository extends JpaRepository<RecipeBook, Long> {

}
