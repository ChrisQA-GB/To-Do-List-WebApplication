package com.example.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.DTO.PokeTaskDTO;
import com.example.demo.data.model.PokeTasks;
import com.example.demo.service.PokeTasksService;


@RestController
@RequestMapping(path = "/poketask") // I have set the base path for the controller at poketasks
@CrossOrigin // this annotation has been placed here to enable the PokeTasks cross origin
public class PokeTasksController {

	@Autowired
	private PokeTasksService pokeTasksService;

	@Autowired
	public PokeTasksController(PokeTasksService pokeTasksService) {
		this.pokeTasksService = pokeTasksService;
	}

	@GetMapping
	public ResponseEntity<List<PokeTaskDTO>> getAllPokeTasks() {

		List<PokeTaskDTO> data = pokeTasksService.readAllPokeTasks();

		return new ResponseEntity<List<PokeTaskDTO>>(data, HttpStatus.OK);
	}

	@GetMapping("/{taskId}")
	public ResponseEntity<PokeTaskDTO> getPokeTaskById(@PathVariable("taskId") Integer id){
		
		PokeTaskDTO data = pokeTasksService.readById(id);
		
		return new ResponseEntity<PokeTaskDTO>(data, HttpStatus.OK);
	}
		
	
	@PostMapping
	public ResponseEntity<PokeTaskDTO> createTask(@Valid @RequestBody PokeTasks pokeTasks) {

		PokeTaskDTO pokeTaskDTO = pokeTasksService.createPokeTask(pokeTasks);
		HttpHeaders headers = new HttpHeaders();
		headers.add("Location", String.valueOf(pokeTaskDTO.getTaskId()));

		return new ResponseEntity<PokeTaskDTO>(pokeTaskDTO, headers, HttpStatus.CREATED);

	}

	@PutMapping("/{taskId}") // setting {pokeTasksId} as a path variable
	public ResponseEntity<PokeTaskDTO> updatePokeTask(@PathVariable("taskId") int id,
			@RequestBody PokeTasks pokeTasks) {

		PokeTaskDTO updatedPokeTasks = pokeTasksService.updatePokeTask(id, pokeTasks);

		return new ResponseEntity<PokeTaskDTO>(updatedPokeTasks, HttpStatus.OK);

	}

	@DeleteMapping("/{taskId}")
	public ResponseEntity<Boolean> deletePokeTask(@PathVariable("taskId") int id) {
		return new ResponseEntity<Boolean>(pokeTasksService.deletePokeTasks(id), HttpStatus.NO_CONTENT);
	}

}
