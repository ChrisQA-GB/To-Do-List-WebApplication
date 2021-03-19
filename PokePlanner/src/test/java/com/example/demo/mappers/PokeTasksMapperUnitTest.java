package com.example.demo.mappers;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.DTO.PokeTaskDTO;
import com.example.demo.data.model.PokeTasks;
import com.example.demo.mappper.PokeTasksMapper;

@SpringBootTest
public class PokeTasksMapperUnitTest {
	
	@Autowired
	PokeTasksMapper pokeTasksMapper;
	PokeTasks pokeTasks;
	PokeTaskDTO pokeTasksDTO;
	
	@BeforeEach
	void settingUpThePokeTasks() {
		
		pokeTasks = new PokeTasks(1, null,  "PokeTask" , "PokeTaskDescription",
			 1, "Tuesday", true);
		pokeTasksDTO = new PokeTaskDTO(1, "PokeTask" , "PokeTaskDescription",
			 1, "Tuesday", true);
	}
	@Test
	void mapToPokeTaskTest() {
		
		assertThat(pokeTasksMapper.mapToPokeTasks(pokeTasksDTO)).isEqualTo(pokeTasks);
	}
	
	@Test
	void mapToPokeTaskDTOTest() {
		
		assertThat(pokeTasksMapper.mapToDTO(pokeTasks)).isEqualTo(pokeTasksDTO);
	}

}
