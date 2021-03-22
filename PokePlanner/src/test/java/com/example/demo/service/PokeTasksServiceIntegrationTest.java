package com.example.demo.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
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

		validPokeTasks = new PokeTasks(1, null, "PokeTask", "PokeDescription", 2, "Tuesday", true);
		validPokeTaskDTO = new PokeTaskDTO();

		pokeTasks = new ArrayList<PokeTasks>();
		pokeTaskDTO = new ArrayList<PokeTaskDTO>();

		pokeTaskRespository.deleteAll();

		validPokeTasks = pokeTaskRespository.save(validPokeTasks);
		validPokeTaskDTO = pokeTasksMapper.mapToDTO(validPokeTasks);

		pokeTasks.add(validPokeTasks);
		pokeTaskDTO.add(validPokeTaskDTO);
	}

	// READ ALL SERVICE TEST
	@Test
	public void readAllPokeTasksTest() {

		List<PokeTaskDTO> pokeTasksInDb = pokeTasksService.readAllPokeTasks();

		assertThat(pokeTaskDTO).isEqualTo(pokeTasksInDb);
	}
	
/*	@Disabled
	@Test
	public void readByIdTest() {
		PokeTaskDTO pokeTasksInDb = pokeTasksService.readById(pokeTasksInDb.getTaskId());
		
		assertThat(pokeTaskDTO).isEqualTo(pokeTasksInDb.getTaskId());
	} */

	// UPDATE SERVICE TASK TEST
	@Test
	public void updatePokeTaskTest() {
		PokeTasks updatePokeTask = new PokeTasks(5, null, "PokeTask", "PokeDescription", 2, "Tuesday", true);
		PokeTaskDTO updatePokeTaskDTO = pokeTasksMapper.mapToDTO(updatePokeTask);
		PokeTaskDTO mapToPokeTaskDTO = pokeTasksService.updatePokeTask(validPokeTasks.getTaskId(), updatePokeTask);
		assertThat(updatePokeTaskDTO).isEqualTo(mapToPokeTaskDTO);
	}

	// CREATE SERVICE INTEGRATION TEST
	@Test
	public void createPokeTaskTest() {

		PokeTasks createPokeTask = new PokeTasks(1, null, "PokeTask", "PokeDescription", 2, "Tuesday", true);
		PokeTaskDTO createPokeTasksDTO = pokeTasksMapper.mapToDTO(createPokeTask);
		PokeTaskDTO pokeTaskInDb = pokeTasksService.createPokeTask(createPokeTask);
		createPokeTasksDTO.setTaskId(pokeTaskInDb.getTaskId());
		assertThat(pokeTaskInDb).isEqualTo(createPokeTasksDTO);

	}
	// DELETE SERVICE INTEGRATION TEST
	@Test
	public void deletePokeTaskTest() {
		assertThat(true).isEqualTo(pokeTasksService.deletePokeTasks(validPokeTasks.getTaskId()));

	}
}
