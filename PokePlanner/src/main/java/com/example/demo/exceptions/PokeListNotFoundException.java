package com.example.demo.exceptions;

import javax.persistence.EntityNotFoundException;

public class PokeListNotFoundException extends EntityNotFoundException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4146090439767951619L;
	
	public PokeListNotFoundException() {
		super(); 
	}

	public PokeListNotFoundException(String message) {
		super(message);
	}

}
