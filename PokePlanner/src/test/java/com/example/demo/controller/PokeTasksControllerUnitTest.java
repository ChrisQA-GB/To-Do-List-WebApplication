package com.example.demo.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.demo.DTO.PokeTaskDTO;
import com.example.demo.data.model.PokeTasks;
import com.example.demo.service.PokeTasksService;

@WebMvcTest(PokeTasksController.class)
public class PokeTasksControllerUnitTest {

	@Autowired
	private PokeTasksController pokeTasksController;

	@MockBean
	private PokeTasksService pokeTasksService;

	private List<PokeTasks> pokeTasks;
	private List<PokeTaskDTO> pokeTaskDTO;

	private PokeTasks validPokeTasks;
	private PokeTaskDTO validPokeTaskDTO;

	@BeforeEach
	public void init() {
		validPokeTasks = new PokeTasks();
		validPokeTaskDTO = new PokeTaskDTO();

		pokeTasks = new ArrayList<PokeTasks>();
		pokeTaskDTO = new ArrayList<PokeTaskDTO>();

		pokeTasks.add(validPokeTasks);
		pokeTaskDTO.add(validPokeTaskDTO);

	}

	@Test
	public void getAllPokeTasksTest() {

		when(pokeTasksService.readAllPokeTasks()).thenReturn(pokeTaskDTO);

		ResponseEntity<List<PokeTaskDTO>> response = new ResponseEntity<List<PokeTaskDTO>>(pokeTaskDTO, HttpStatus.OK);

		assertThat(response).isEqualTo(pokeTasksController.getAllPokeTasks());

		verify(pokeTasksService, times(1)).readAllPokeTasks();
	}
	
	@Test
	public void getPokeTaskById() {
		
		when(pokeTasksService.readById(validPokeTasks.getTaskId())).thenReturn(validPokeTaskDTO);
		
		ResponseEntity<PokeTaskDTO> response = new ResponseEntity<PokeTaskDTO>(validPokeTaskDTO, HttpStatus.OK);
		
		assertThat(response).isEqualTo(pokeTasksController.getPokeTaskById(validPokeTaskDTO.getTaskId()));
		
		verify(pokeTasksService, times(1)).readById(validPokeTaskDTO.getTaskId());
	}
	
	@Test
	public void updatePokeListTest() {
		
		when(pokeTasksService.updatePokeTask(validPokeTasks.getTaskId(), validPokeTasks)).thenReturn(validPokeTaskDTO);
		
		ResponseEntity<PokeTaskDTO> response = new ResponseEntity<PokeTaskDTO>(validPokeTaskDTO, HttpStatus.OK);
		
		assertThat(response).isEqualTo(pokeTasksController.updatePokeTask(validPokeTasks.getTaskId(), validPokeTasks));
		
		verify(pokeTasksService, times(1)).updatePokeTask(validPokeTasks.getTaskId(), validPokeTasks);
	}
	
	@Test
	public void createPokeTaskTest() {

		when(pokeTasksService.createPokeTask(validPokeTasks)).thenReturn(validPokeTaskDTO);
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("Location", String.valueOf(validPokeTaskDTO.getTaskId()));
		
		ResponseEntity<PokeTaskDTO> response = new ResponseEntity<PokeTaskDTO>(validPokeTaskDTO, headers, HttpStatus.CREATED);
		
		assertThat(response).isEqualTo(pokeTasksController.createTask(validPokeTasks));
	
		verify(pokeTasksService, times(1)).createPokeTask(validPokeTasks);
	}
	
	@Test
	public void deletePokeTaskTest() {
		
		when(pokeTasksService.deletePokeTasks(validPokeTasks.getTaskId())).thenReturn(true);
		
		ResponseEntity<Boolean> response = new ResponseEntity<Boolean>(true, HttpStatus.NO_CONTENT);
		
		assertThat(response).isEqualTo(pokeTasksController.deletePokeTask(validPokeTasks.getTaskId()));
		
		verify(pokeTasksService, times(1)).deletePokeTasks((validPokeTasks.getTaskId()));
 }
}