package com.example.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.DTO.PokeListDTO;
import com.example.demo.DTO.PokeTaskDTO;
import com.example.demo.data.model.PokeList;
import com.example.demo.data.model.PokeTasks;
import com.example.demo.service.PokeListService;

@RestController
@RequestMapping("/pokelist")
public class PokeListController {

	@Autowired
	private PokeListService pokeListService;

	@Autowired
	public PokeListController(PokeListService pokeListService) {
		this.pokeListService = pokeListService;
	}

// READ POKELISTS
	@GetMapping
	public ResponseEntity<List<PokeListDTO>> getAllPokeLists() {

		List<PokeListDTO> data = pokeListService.readAll();

		return new ResponseEntity<List<PokeListDTO>>(data, HttpStatus.OK);
	}

// CREATE POKELIST 
	@PostMapping
	public ResponseEntity<PokeListDTO> createTask(@Valid @RequestBody PokeList pokeList) {

		PokeListDTO pokeListDTO = pokeListService.createPokeList(pokeList);
		HttpHeaders headers = new HttpHeaders();
		headers.add("Location", String.valueOf(pokeListDTO.getPokeListId()));

		return new ResponseEntity<PokeListDTO>(pokeListDTO, headers, HttpStatus.CREATED);

	}
// UPDATE POKELIST
	@PutMapping("/{pokeListId}") // setting {pokeListId} as a path variable
	public ResponseEntity<PokeListDTO> updatePokeList(@PathVariable("pokeListId") int id,
			@RequestBody PokeList pokeList) {

		PokeListDTO updatedPokeList = pokeListService.updatePokeList(id, pokeList);

		return new ResponseEntity<PokeListDTO>(updatedPokeList, HttpStatus.OK);

	}
	//DELETE
	
	@DeleteMapping("/{pokeListId}")
	public ResponseEntity<Boolean> deletePokeList(@PathVariable("pokeListId") int id) {
		return new ResponseEntity<Boolean>(pokeListService.deletePokeList(id), HttpStatus.OK);
	}
	
}

