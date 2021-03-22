package com.example.demo.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.demo.DTO.PokeListDTO;
import com.example.demo.data.model.PokeList;
import com.example.demo.data.respository.PokeListRespository;
import com.example.demo.mappper.PokeListMapper;

@ExtendWith(MockitoExtension.class)
public class PokeListServiceUnitTest {
	

	@InjectMocks
	private PokeListService pokeListService;
	
	@Mock
	private PokeListRespository pokeListRespository;
	
	@Mock
	private PokeListMapper pokeListMapper;
	
	private List<PokeList> pokeList;
	private List<PokeListDTO> pokeListDTO;
	
	private PokeList validPokeList;
	private PokeListDTO validPokeListDTO;
	
	@BeforeEach
	public void init() {
		validPokeList = new PokeList();
		validPokeListDTO = new PokeListDTO();
		
		pokeList = new ArrayList<PokeList>();
		pokeListDTO = new ArrayList<PokeListDTO>();
		
		pokeList.add(validPokeList);
		pokeListDTO.add(validPokeListDTO);
		
	}
	
	@Test
	public void readAllPokeTasksTest() {
		// When a specific method is called on a mock object,
		// we can specify what is returned
		when(pokeListRespository.findAll()).thenReturn(pokeList);
		when(pokeListMapper.mapToDTO(validPokeList)).thenReturn(validPokeListDTO);
				
				// When the service is called, this will initiate the
				// when-then returns
		assertThat(pokeListDTO).isEqualTo(pokeListService.readAll()); // true or false
				
				// Verify that our methods on our mock objects were called
		verify(pokeListRespository, times(1)).findAll();
		verify(pokeListMapper, times(1)).mapToDTO(validPokeList);
			}
	
	@Test
	public void createPokeListTest() {
		when(pokeListRespository.save(Mockito.any(PokeList.class))).thenReturn(validPokeList);
		when(pokeListMapper.mapToDTO(Mockito.any(PokeList.class))).thenReturn(validPokeListDTO);
		
		assertThat(validPokeListDTO).isEqualTo(pokeListService.createPokeList(validPokeList));
		
		verify(pokeListRespository, times(1)).save(validPokeList);
		verify(pokeListMapper, times(1)).mapToDTO(validPokeList);
	 }
	
	@Test
	public void updatePokeListTest() {
		PokeList updatedPokeList = new PokeList();
		PokeListDTO updatedPokeListDTO = new PokeListDTO();
		
		when(pokeListRespository.findById(Mockito.any(Integer.class)))
			.thenReturn(Optional.of(validPokeList));
		
		when(pokeListRespository.save(Mockito.any(PokeList.class)))
			.thenReturn(updatedPokeList);
		
		when(pokeListMapper.mapToDTO(Mockito.any(PokeList.class)))
			.thenReturn(updatedPokeListDTO);
		
		PokeListDTO toTestDTO = pokeListService.updatePokeList(validPokeList.getPokeListId(), updatedPokeList);
		
		assertThat(updatedPokeListDTO).isEqualTo(toTestDTO);  
	}
	@Test
	public void deletePokeList() {
		when(pokeListRespository.existsById(Mockito.any(Integer.class)))
		.thenReturn(true).thenReturn(false);
		
		assertThat(true).isEqualTo(pokeListService.deletePokeList(validPokeList.getPokeListId()));
		
		verify(pokeListRespository, times(2)).existsById(validPokeList.getPokeListId());
		verify(pokeListRespository, times(1)).deleteById(validPokeList.getPokeListId());
		
	}
}
