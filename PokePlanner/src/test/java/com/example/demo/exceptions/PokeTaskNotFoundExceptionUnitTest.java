package com.example.demo.exceptions;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class PokeTaskNotFoundExceptionUnitTest {

	@Test
	public void PokeTaskNotFouncExceptionConstructorTest() {
		PokeTasksNotFoundException pokeTaskNFE = new PokeTasksNotFoundException();
		
		assertThat(pokeTaskNFE).isNotNull().isInstanceOf(PokeTasksNotFoundException.class);
		
	}
	

	@Test
	public void PokeTaskNotFouncExceptionConstructorTest1() {
		PokeTasksNotFoundException pokeTaskNFE = new PokeTasksNotFoundException("Hi There");
		
		assertThat(pokeTaskNFE).isNotNull().isInstanceOf(PokeTasksNotFoundException.class);
	
		//assertThat(pokeTaskNFE).isNotNull().isEqualTo("Hi There");
		
		
	}
	/*
	public void PokeTasksNotFoundExceptionTest() {
		return null; 
	}
	@Test
	public void PokeTasksNotFoundExceptionTest1() {
		return null; */
	}



