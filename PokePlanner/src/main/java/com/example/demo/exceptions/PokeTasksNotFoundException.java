package com.example.demo.exceptions;

import javax.persistence.EntityNotFoundException;

public class PokeTasksNotFoundException extends EntityNotFoundException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4828358468271919655L;
	
	public PokeTasksNotFoundException() {
		super(); 
	}

	public PokeTasksNotFoundException(String message) {
		super(message);
	}
}
