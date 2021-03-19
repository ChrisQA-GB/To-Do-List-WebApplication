package com.example.demo.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.DTO.PokeTaskDTO;
import com.example.demo.data.model.PokeTasks;
import com.example.demo.data.respository.PokeTaskRespository;
import com.example.demo.mappper.PokeTasksMapper;

@SpringBootTest
public class PokeTasksServiceIntegrationTest {
	

	@Autowired
	private PokeTasksService pokeTasksService;
	
	@Autowired
	private PokeTaskRespository pokeTaskRespository;
	
	@Autowired
	private PokeTasksMapper pokeTasksMapper;
	
	private List<PokeTasks> pokeTasks;
	private List<PokeTaskDTO> pokeTaskDTO;
	
	private PokeTasks validPokeTasks;
	private PokeTaskDTO validPokeTaskDTO;
	
	@BeforeEach
	public void init() {
		// setup our valid duck data to be saved to the db
		validPokeTasks = new PokeTasks();
		validPokeTaskDTO = new PokeTaskDTO();
		
		// initialise our lists
		pokeTasks = new ArrayList<PokeTasks>();
		pokeTaskDTO = new ArrayList<PokeTaskDTO>();
				
		// Reset the state of the db before each test
		pokeTaskRespository.deleteAll();
		
		// prepopulate the db (get the saved duck back)
		validPokeTasks = pokeTaskRespository.save(validPokeTasks);
		
		// map the saved duck to a DTO
		validPokeTaskDTO = pokeTasksMapper.mapToDTO(validPokeTasks);
		
		// add the saved duck and corresponding DTO to the relevant lists
		pokeTasks.add(validPokeTasks);
		pokeTaskDTO.add(validPokeTaskDTO);
	}
	
	@Test
	public void readAllDucksTest() {
		// Get all ducks stored in the db
		List<PokeTaskDTO> pokeTasksInDb = pokeTasksService.readAllPokeTasks();
		
		// compare to our expected values
		assertThat(pokeTaskDTO).isEqualTo(pokeTasksInDb);
	}
	
}
