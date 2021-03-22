package com.example.demo.data.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import nl.jqno.equalsverifier.EqualsVerifier;

public class PokeTasksUnitTest {
	
	@Test
	public void PokeTaskConstructorTest() {
		PokeTasks pokeTask = new PokeTasks();
		
		assertThat(pokeTask).isNotNull().isInstanceOf(PokeTasks.class);
	
	}
	
	@Test
	public void PokeTaskConstructorTest1() {
		PokeTasks pokeTask = new PokeTasks(1, null, "PokeTask", "PokeDescription",
				 2, "Tuesday", true);
		
		assertThat(pokeTask).isNotNull().isInstanceOf(PokeTasks.class);
		assertThat(pokeTask.getTaskId()).isEqualTo(1);
		assertThat(pokeTask.getPokeList()).isEqualTo(null);
		assertThat(pokeTask.getPokeTask()).isEqualTo("PokeTask");
		assertThat(pokeTask.getPokeTaskDescription()).isEqualTo("PokeDescription");			
		assertThat(pokeTask.getDifficulty()).isEqualTo(2);
		assertThat(pokeTask.getDate()).isEqualTo("Tuesday");
		assertThat(pokeTask.isCompletedTickBox()).isEqualTo(true);

	}
	
	@Test
	public void PokeTaskOConstructorTest2() {
		PokeTasks pokeTask = new PokeTasks(null, "PokeTask", "PokeDescription",
				 2, "Tuesday", true);
		
		assertThat(pokeTask).isNotNull().isInstanceOf(PokeTasks.class);
		assertThat(pokeTask.getPokeList()).isEqualTo(null);
		assertThat(pokeTask.getPokeTask()).isEqualTo("PokeTask");
		assertThat(pokeTask.getPokeTaskDescription()).isEqualTo("PokeDescription");			
		assertThat(pokeTask.getDifficulty()).isEqualTo(2);
		assertThat(pokeTask.getDate()).isEqualTo("Tuesday");
		assertThat(pokeTask.isCompletedTickBox()).isEqualTo(true);
	}
	
	
	
	//Unable to use the .verify() method due to the Recurrsion, need to use .withPrefavValues to counter this problem. 
	
	@Test
	public void TestEquals() {
		
		EqualsVerifier.simple().forClass(PokeTasks.class).withPrefabValues(PokeTasks.class, new PokeTasks( "Hello", "Bye", 1, "Tuesday",false), new PokeTasks( "Haha", "Bye", 1, "Tuesday",false)).verify();
	}

}
