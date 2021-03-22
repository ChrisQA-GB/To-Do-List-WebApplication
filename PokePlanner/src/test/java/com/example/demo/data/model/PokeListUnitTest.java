package com.example.demo.data.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import nl.jqno.equalsverifier.EqualsVerifier;

public class PokeListUnitTest {

	
	@Test
	public void PokeListConstructorTest() {
		PokeList pokeList = new PokeList();
		
		assertThat(pokeList).isNotNull().isInstanceOf(PokeList.class);
		
	}
	
	@Test
	public void PokeListConstructorTest1() {
		PokeList pokeList = new PokeList(1, "This is a PokeStringTest");
		
		assertThat(pokeList).isNotNull().isInstanceOf(PokeList.class);
		assertThat(pokeList.getPokeListId()).isEqualTo(1);
		assertThat(pokeList.getPokeList()).isEqualTo("This is a PokeStringTest");
	}
	@Test
	public void PokeListConstructorTest2() {
		PokeList pokeList = new PokeList(1, "This is a PokeStringTest", null);
		
		assertThat(pokeList).isNotNull().isInstanceOf(PokeList.class);
		assertThat(pokeList.getPokeListId()).isEqualTo(1);
		assertThat(pokeList.getPokeList()).isEqualTo("This is a PokeStringTest");
		assertThat(pokeList.getPokeTasks()).isEqualTo(null);
	}
	
	
	
	
	//Unable to use the .verify() method due to the Recurrsion, need to use .withPrefavValues to counter this problem. 
	
	@Test
	public void TestEquals() {
		
	EqualsVerifier.simple().forClass(PokeList.class).withPrefabValues(PokeList.class, new PokeList("Hello"), new PokeList( "Please Work")).verify();
	}

}


