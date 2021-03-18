package com.example.demo.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
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
		validPokeTasks = new PokeTasks(1,"UNO","DOS","TRES",)
		validPokeTaskDTO = new PokeTaskDTO(1,"UNO","DOS","TRES", 2, 23/10/1997, );
	
		pokeTasks = new ArrayList<PokeTasks>();
		pokeTaskDTO = new ArrayList<PokeTaskDTO>();
		
		pokeTasks.add(validPokeTasks);
		pokeTaskDTO.add(validPokeTaskDTO);
		
	}
	
	@Test 
	public void getAllPokeTasksTest() {
	
		EntityModel<PokeTaskDTO> pokeTaskEntityModel = EntityModel.of(validPokeTaskDTO,
				linkTo(methodOn(PokeTasksController.class).getDuckById(validPokeTaskDTO.getId())).withSelfRel(), // link to the current entity
				linkTo(methodOn(PokeTasksController.class).getAllPokeTasks()).withRel("pokeTasks"));
		
		ResponseEntity<EntityModel<PokeTaskDTO>> response = 
				new ResponseEntity<EntityModel<PokeTaskDTO>>(pokeTaskEntityModel, HttpStatus.OK);
		
		assertThat(response).isEqualTo(pokeTasksController.getPokeTaskById(validPokeTasks.getTaskId()));
		
		verify(pokeTasksService, times(1)).readById(validPokeTaskDTO.getTaskId());
	}
	
	@Test
	public void getPokeTaskByIdAltTest() {
		when(pokeTasksService.readById(Mockito.any(Integer.class))).thenReturn(validPokeTaskDTO);
		
		ResponseEntity<PokeTaskDTO> response = 
				new ResponseEntity<PokeTaskDTO>(validPokeTaskDTO, HttpStatus.OK);
		
		assertThat(response).isEqualTo(pokeTasksController.getPokeTaskByIdAlt(validPokeTasks.getTaskId()));
		
		verify(pokeTasksService, times(1)).readById(Mockito.any(Integer.class));
	}
	
	@Test
	public void createPokeTaskTest() {
		EntityModel<PokeTaskDTO> pokeTaskEntityModel = EntityModel.of(validPokeTaskDTO,
				linkTo(methodOn(PokeTasksController.class).getPokeTaskById(validPokeTaskDTO.getTaskId())).withSelfRel(), // link to the current entity
				linkTo(methodOn(PokeTasksController.class).getAllPokeTasks()).withRel("pokeTasks"));
		
		when(pokeTasksService.createPokeTask(validPokeTasks)).thenReturn(validPokeTaskDTO);
		when(duckDTOModelAssembler.toModel(validDuckDTO)).thenReturn(duckEntityModel);
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("Location", String.valueOf(validDuckDTO.getId()));
		
		ResponseEntity<EntityModel<DuckDTO>> response = 
				ResponseEntity.created(
						duckEntityModel.getRequiredLink(IanaLinkRelations.SELF).toUri()
				).body(duckEntityModel);
		
		assertThat(response).isEqualTo(duckController.createDuck(validDuck));
		
		verify(pokeTasksService, times(1)).createPokeTask(validPokeTasks);
		verify(duckDTOModelAssembler, times(1)).toModel(validPokeTaskDTO);
	}
	
	@Test
	public void deleteDuckTest() {
		// We only need to mock deleteDuck
		when(pokeTasksService.getPokeTaskById(validPokeTasks.getTaskId())).thenReturn(validPokeTaskDTO);
		when(pokeTasksService.deletePokeTasks(validPokeTasks.getTaskId())).thenReturn(true);
		
		// expected response should return true with a following Http Status update to the user.
		ResponseEntity<Boolean> response =
				new ResponseEntity<Boolean>(true, HttpStatus.NO_CONTENT);
		
		// Checking our expected response is equal to the actual response
		// of the controller.deleteDuck method
		assertThat(response).isEqualTo(pokeTasksController.deletePokeTask(validPokeTasks.getTaskId()));
		
		verify(pokeTasksService, times(1)).getPokeTaskById(validPokeTasks.getTaskId());
		verify(pokeTasksService, times(1)).deletePokeTasks(validPokeTasks.getTaskId());
	}
	
	@Test
	public void updatePokeTasksTest() {
		EntityModel<PokeTaskDTO> pokeTaskEntityModel = EntityModel.of(validPokeTaskDTO,
				linkTo(methodOn(PokeTasksController.class).getPokeTaskById(validPokeTaskDTO.getTaskId())).withSelfRel(), // link to the current entity
				linkTo(methodOn(PokeTasksController.class).getAllPokeTasks()).withRel("pokeTasks"));
		
		// mock the update duck method
		when(pokeTasksService.updatePokeTask(validPokeTasks.getTaskId(), validPokeTasks))
			.thenReturn(validPokeTaskDTO);
		
		when(pokeTaskDTOModelAssembler.toModel(validPokeTaskDTO)).thenReturn(pokeTaskEntityModel);
		
		HttpHeaders headers = new HttpHeaders();
		// Link from model is turned into URI, and then into String
		headers.add("Location", pokeTaskEntityModel.getRequiredLink(IanaLinkRelations.SELF).toUri().toString());
		
		// expected response
		ResponseEntity<EntityModel<PokeTaskDTO>> response =
				new ResponseEntity<EntityModel<PokeTaskDTO>>(pokeTaskEntityModel, headers, HttpStatus.OK);
		
		// check our response
		assertThat(response).isEqualTo(pokeTasksController.updatePokeTask(validPokeTasks.getTaskId(), validPokeTasks));
		
		// verify the response
		verify(pokeTasksService, times(1)).updateDuck(validPokeTasks.getTaskId(), validPokeTasks);
	}
}

}
