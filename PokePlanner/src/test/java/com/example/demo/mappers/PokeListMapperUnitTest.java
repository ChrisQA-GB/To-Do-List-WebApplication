package com.example.demo.mappers;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.DTO.PokeListDTO;
import com.example.demo.data.model.PokeList;
import com.example.demo.mappper.PokeListMapper;

@SpringBootTest
public class PokeListMapperUnitTest {
	
	@Autowired
	PokeListMapper pokeListMapper;
	PokeList pokeList;
	PokeListDTO pokeListDTO;
	
	@BeforeEach
	void settingUpThePokeTasks() {
		
		pokeList = new PokeList("PokeListString");
		pokeListDTO = new PokeListDTO("PokeListString");
	}
	@Test
	void mapToPokeTaskTest() {
		
		assertThat(pokeListMapper.mapToPokeList(pokeListDTO)).isEqualTo(pokeList);
	}
	
	@Test
	void mapToPokeTaskDTOTest() {
		
		assertThat(pokeListMapper.mapToDTO(pokeList)).isEqualTo(pokeListDTO);
	}

}
