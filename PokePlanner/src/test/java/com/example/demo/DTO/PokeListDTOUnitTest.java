package com.example.demo.DTO;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import nl.jqno.equalsverifier.EqualsVerifier;

public class PokeListDTOUnitTest {

	@Test
	public void PokeListDTOConstructorTest() {
		PokeListDTO pokeListDTO = new PokeListDTO();
		
		assertThat(pokeListDTO).isNotNull().isInstanceOf(PokeListDTO.class);
		
	}
	
	
	@Test
	public void PokeListDTOConstructorTest1() {
	PokeListDTO pokeListDTO = new PokeListDTO("This is a PokeStringTest");
	
	assertThat(pokeListDTO).isNotNull().isInstanceOf(PokeListDTO.class);
	assertThat(pokeListDTO.getPokeList()).isEqualTo("This is a PokeStringTest");
	}
		
		
		
	@Test
	public void PokeListDTOConstructorTest2() {
	PokeListDTO pokeListDTO = new PokeListDTO(1,"This is a PokeStringTest", null);
	
	assertThat(pokeListDTO).isNotNull().isInstanceOf(PokeListDTO.class);
		assertThat(pokeListDTO.getPokeListId()).isEqualTo(1);
		assertThat(pokeListDTO.getPokeList()).isEqualTo("This is a PokeStringTest");
		assertThat(pokeListDTO.getPokeTasks()).isEqualTo(null);
	}
	@Test
	public void PokeListDTOToStringTest() {
		PokeListDTO pokeListDTO = new PokeListDTO(1,"This is a PokeStringTest", null);
		
		assertThat(pokeListDTO).hasToString("PokeListDTO [pokeListId=" + pokeListDTO.getPokeListId() 
		+ ", pokeList=" + pokeListDTO.getPokeList() + ", pokeTasks=" + pokeListDTO.getPokeTasks() + "]");
	}
	@Test
	public void EqualsVerify() {
	EqualsVerifier.simple().forClass(PokeListDTO.class).verify();
	
	//.withPrefabValues(PokeListDTO.class, new PokeList("Hello"), new PokeList( "Please Work")).verify();
	}

}