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

import com.example.demo.DTO.PokeListDTO;
import com.example.demo.data.model.PokeList;
import com.example.demo.service.PokeListService;

@WebMvcTest(PokeListController.class)
public class PokeListControllerUnitTest {
	

	@Autowired
	private PokeListController pokeListController;

	@MockBean
	private PokeListService pokeListService;

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
	public void getAllPokeTasksTest() {

		when(pokeListService.readAll()).thenReturn(pokeListDTO);

		ResponseEntity<List<PokeListDTO>> response = new ResponseEntity<List<PokeListDTO>>(pokeListDTO, HttpStatus.OK);

		assertThat(response).isEqualTo(pokeListController.getAllPokeLists());

		verify(pokeListService, times(1)).readAll();
	}
	
	@Test
	public void updatePokeListTest() {
		
		when(pokeListService.updatePokeList(validPokeList.getPokeListId(), validPokeList)).thenReturn(validPokeListDTO);
		
		ResponseEntity<PokeListDTO> response = new ResponseEntity<PokeListDTO>(validPokeListDTO, HttpStatus.OK);
		
		assertThat(response).isEqualTo(pokeListController.updatePokeList(validPokeList.getPokeListId(), validPokeList));
		
		verify(pokeListService, times(1)).updatePokeList(validPokeList.getPokeListId(), validPokeList);
	}
	
	@Test
	public void createPokeListTest() {

		when(pokeListService.createPokeList(validPokeList)).thenReturn(validPokeListDTO);
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("Location", String.valueOf(validPokeListDTO.getPokeListId()));
		
		ResponseEntity<PokeListDTO> response = new ResponseEntity<PokeListDTO>(validPokeListDTO, headers, HttpStatus.CREATED);
		assertThat(response).isEqualTo(pokeListController.createTask(validPokeList));
		verify(pokeListService, times(1)).createPokeList(validPokeList);
	}
	
	@Test
	public void deletePokeListTest() {
		
		when(pokeListService.deletePokeList(validPokeList.getPokeListId())).thenReturn(true);
		
		ResponseEntity<Boolean> response = new ResponseEntity<Boolean>(true, HttpStatus.NO_CONTENT);
		
		assertThat(response).isEqualTo(pokeListController.deletePokeList(validPokeList.getPokeListId()));
		
		verify(pokeListService, times(1)).deletePokeList((validPokeList.getPokeListId()));
	}
	

}
