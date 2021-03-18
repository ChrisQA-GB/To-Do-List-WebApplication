package com.example.demo.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.demo.DTO.PokeTaskDTO;
import com.example.demo.data.model.PokeTasks;
import com.example.demo.data.respository.PokeTaskRespository;
import com.example.demo.mappper.PokeTasksMapper;

@ExtendWith(MockitoExtension.class)
public class PokeTasksServiceUnitTest {

	@InjectMocks
	private PokeTasksService pokeTasksService;
	
	@Mock
	private PokeTaskRespository pokeTasksRespository;
	
	@Mock
	private PokeTasksMapper pokeTasksMapper;
	
	private List<PokeTasks> pokeTasks;
	private List<PokeTaskDTO> pokeTasksDTO;
	
	private PokeTasks validPokeTasks;
	private PokeTaskDTO validPokeTaskDTO;
	
	@BeforeEach
	public void init() {
		validPokeTasks = new PokeTasks();
		validPokeTaskDTO = new PokeTaskDTO();
		
		pokeTasks = new ArrayList<PokeTasks>();
		pokeTasksDTO = new ArrayList<PokeTaskDTO>();
		
		pokeTasks.add(validPokeTasks);
		pokeTasksDTO.add(validPokeTaskDTO);
		
	}
	
	@Test
	public void readAllPokeTasksTest() {
		// When a specific method is called on a mock object,
		// we can specify what is returned
		when(pokeTasksRespository.findAll()).thenReturn(pokeTasks);
		when(pokeTasksMapper.mapToDTO(validPokeTasks)).thenReturn(validPokeTaskDTO);
				
				// When the service is called, this will initiate the
				// when-then returns
		assertThat(pokeTasksDTO).isEqualTo(pokeTasksService.readAllPokeTasks()); // true or false
				
				// Verify that our methods on our mock objects were called
		verify(pokeTasksRespository, times(1)).findAll();
		verify(pokeTasksMapper, times(1)).mapToDTO(validDuck);
			}
	}
	
}
