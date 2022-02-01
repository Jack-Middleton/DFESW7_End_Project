package com.qa.RecipeApp.exceptions;

import javax.persistence.EntityNotFoundException;

public class RecipeNotFoundException extends EntityNotFoundException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4703951096369449766L;

	public RecipeNotFoundException(String errorMessage) {
		super(errorMessage);
	}

}
