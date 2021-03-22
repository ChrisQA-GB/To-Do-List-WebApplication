package com.example.demo.exceptions;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class PokeListNotFoundExceptionUnitTest {

	@Test
	public void PokeTaskNotFouncExceptionConstructorTest() {
		PokeListNotFoundException pokeListNFE = new PokeListNotFoundException();
		
		assertThat(pokeListNFE).isNotNull().isInstanceOf(PokeListNotFoundException.class);
		
	}
	

	@Test
	public void PokeListNotFouncExceptionConstructorTest1() {
		PokeListNotFoundException pokeListNFE = new PokeListNotFoundException("Hi There");
		
		assertThat(pokeListNFE).isNotNull().isInstanceOf(PokeListNotFoundException.class);

	}
}