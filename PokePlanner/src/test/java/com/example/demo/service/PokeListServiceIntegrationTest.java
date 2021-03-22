package com.example.demo.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.DTO.PokeListDTO;
import com.example.demo.data.model.PokeList;
import com.example.demo.data.model.PokeTasks;
import com.example.demo.data.respository.PokeListRespository;
import com.example.demo.mappper.PokeListMapper;

@SpringBootTest
public class PokeListServiceIntegrationTest {
	

	@Autowired
	private PokeListService pokeListService;
	
	@Autowired
	private PokeListRespository pokeListRespository;
	
	@Autowired
	private PokeListMapper pokeListMapper;
	
	private List<PokeList> pokeList;
	private List<PokeListDTO> pokeListDTO;
	
	private PokeList validPokeList;
	private PokeListDTO validPokeListDTO;
	
	@BeforeEach
	public void init() {
		
		validPokeList = new PokeList(1, "This is a PokeStringTest", new ArrayList<PokeTasks>());
		validPokeListDTO = new PokeListDTO();
		

		pokeList = new ArrayList<PokeList>();
		pokeListDTO = new ArrayList<PokeListDTO>();
				

		pokeListRespository.deleteAll();
		

		validPokeList = pokeListRespository.save(validPokeList);
		

		validPokeListDTO = pokeListMapper.mapToDTO(validPokeList);
		

		pokeList.add(validPokeList);
		pokeListDTO.add(validPokeListDTO);
	}
	
	@Test
	public void readAllDucksTest() {
	
		List<PokeListDTO> pokeListInDb = pokeListService.readAll();
		
	
		assertThat(pokeListDTO).isEqualTo(pokeListInDb);
	}
	

	// UPDATE SERVICE TASK TEST
	@Test
	public void updatePokeTaskTest() {
		PokeList updatePokeList = new PokeList(3, "This is a PokeStringTest", null);
		PokeListDTO updatePokeListDTO = pokeListMapper.mapToDTO(updatePokeList);
		PokeListDTO mapToPokeListDTO = pokeListService.updatePokeList(validPokeList.getPokeListId(), updatePokeList);
		assertThat(updatePokeListDTO).isEqualTo(mapToPokeListDTO);
	}

	// CREATE SERVICE INTEGRATION TEST
	@Disabled
	@Test
	public void createPokeTaskTest() {

		PokeList createPokeList = new PokeList(1, "This is a PokeStringTest", null);
		PokeListDTO createPokeListDTO = pokeListMapper.mapToDTO(createPokeList);
		PokeListDTO pokeTaskInDb = pokeListService.createPokeList(createPokeList);
		createPokeListDTO.setPokeListId(pokeTaskInDb.getPokeListId());
		assertThat(pokeTaskInDb).isEqualTo(pokeTaskInDb);
	}
	// DELETE SERVICE INTEGRATION TEST
	@Test
	public void deletePokeTaskTest() {
		assertThat(true).isEqualTo(pokeListService.deletePokeList(validPokeList.getPokeListId()));

	}
}
