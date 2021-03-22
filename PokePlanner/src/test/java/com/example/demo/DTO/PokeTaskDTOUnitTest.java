package com.example.demo.DTO;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import nl.jqno.equalsverifier.EqualsVerifier;

public class PokeTaskDTOUnitTest {
	
	@Test
	public void PokeTaskConstructorTest() {
		PokeTaskDTO pokeTaskDTO = new PokeTaskDTO();
		
		assertThat(pokeTaskDTO).isNotNull().isInstanceOf(PokeTaskDTO.class);
	
	}
	
	@Test
	public void PokeTaskDTOConstructorTest1() {
		PokeTaskDTO pokeTaskDTO = new PokeTaskDTO(1, "PokeTask", "PokeDescription",
				 2, "Tuesday", true);
		
		assertThat(pokeTaskDTO).isNotNull().isInstanceOf(PokeTaskDTO.class);
		assertThat(pokeTaskDTO.getTaskId()).isEqualTo(1);
		assertThat(pokeTaskDTO.getPokeTask()).isEqualTo("PokeTask");
		assertThat(pokeTaskDTO.getPokeTaskDescription()).isEqualTo("PokeDescription");			
		assertThat(pokeTaskDTO.getDifficulty()).isEqualTo(2);
		assertThat(pokeTaskDTO.getDate()).isEqualTo("Tuesday");
		assertThat(pokeTaskDTO.isCompletedTickBox()).isEqualTo(true);

	}
	
	@Test
	public void PokeTaskDTOOConstructorTest2() {
		PokeTaskDTO pokeTaskDTO = new PokeTaskDTO( "PokeTask", "PokeDescription",
				 2, "Tuesday", true);
		
		assertThat(pokeTaskDTO).isNotNull().isInstanceOf(PokeTaskDTO.class);
		assertThat(pokeTaskDTO.getPokeTask()).isEqualTo("PokeTask");
		assertThat(pokeTaskDTO.getPokeTaskDescription()).isEqualTo("PokeDescription");			
		assertThat(pokeTaskDTO.getDifficulty()).isEqualTo(2);
		assertThat(pokeTaskDTO.getDate()).isEqualTo("Tuesday");
		assertThat(pokeTaskDTO.isCompletedTickBox()).isEqualTo(true);
	}
	
	
	@Test
	public void pokeTaskDTOToStringTest() {
		PokeTaskDTO pokeTaskDTO = new PokeTaskDTO(1, "PokeTask", "PokeDescription",
				 2, "Tuesday", true);
		
		assertThat(pokeTaskDTO).hasToString("PokeTaskDTO [taskId=" + pokeTaskDTO.getTaskId() + ", pokeTask=" + pokeTaskDTO.getPokeTask() + 
				", pokeTaskDescription="+ pokeTaskDTO.getPokeTaskDescription() + ", difficulty=" + pokeTaskDTO.getDifficulty() + 
				", date=" + pokeTaskDTO.getDate() + ", completedTickBox=" + pokeTaskDTO.isCompletedTickBox() + "]");
		
	}
	
	
	
	
	@Test
	public void TestEquals() {
		
		EqualsVerifier.simple().forClass(PokeTaskDTO.class).verify();
		
		//.withPrefabValues(PokeTaskDTO.class, new PokeTasks( "Hello", "Bye", 1, "Tuesday",false), new PokeTasks( "Haha", "Bye", 1, "Tuesday",false)).verify();;
	}


}
