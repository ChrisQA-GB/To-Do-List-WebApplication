package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.DTO.PokeTaskDTO;
import com.example.demo.data.model.PokeTasks;
import com.example.demo.data.respository.PokeTaskRespository;
import com.example.demo.exceptions.PokeTasksNotFoundException;
import com.example.demo.mappper.PokeTasksMapper;

@Service
public class PokeTasksService {

	// This is my Data Access Object (DAO)
	private PokeTaskRespository pokeTasksRespository;

	private PokeTasksMapper pokeTasksMapper;

	@Autowired
	public PokeTasksService(PokeTaskRespository pokeTasksRespository, PokeTasksMapper pokeTasksMapper) {
		this.pokeTasksRespository = pokeTasksRespository;
		this.pokeTasksMapper = pokeTasksMapper;
	}

	// Creating Read Functionality.
	// READ ALL 
	public List<PokeTaskDTO> readAllPokeTasks() {
		List<PokeTasks> pokeTasks = pokeTasksRespository.findAll();
		List<PokeTaskDTO> pokeTaskDTO = new ArrayList<PokeTaskDTO>();

		pokeTasks.forEach(pokeTask -> pokeTaskDTO.add(pokeTasksMapper.mapToDTO(pokeTask)));

		return pokeTaskDTO;
	}

	// READ BY ID
	public PokeTaskDTO readById(Integer id) {

		if (!pokeTasksRespository.existsById(id)) {
			throw new PokeTasksNotFoundException("Please enter a valid PokeTask ID to continue");
		}
		{
			PokeTasks pokeTasks = pokeTasksRespository.getPokeTaskByIdJPQL(id);

			return pokeTasksMapper.mapToDTO(pokeTasks);
		}
	}

//	This method is used to create a new Task within the table.
	public PokeTaskDTO createPokeTask(PokeTasks pokeTasks) {
		PokeTasks newPokeTasks = pokeTasksRespository.save(pokeTasks);

		return pokeTasksMapper.mapToDTO(newPokeTasks);
	}

	// This method is used to update an already existing PokeTask
	public PokeTaskDTO updatePokeTask(Integer id, PokeTasks pokeTasks) throws EntityNotFoundException {
		Optional<PokeTasks> pokeTasksInDbOpt = pokeTasksRespository.findById(id);
		PokeTasks pokeTasksInDb;

		if (pokeTasksInDbOpt.isPresent()) {
			pokeTasksInDb = pokeTasksInDbOpt.get();
		} else {
			throw new PokeTasksNotFoundException("Error - Task not found. /nPlease ensure Task has been set");
		}
		// Added all variables within the PokeTasks class excluding TaskId.
		pokeTasksInDb.setPokeTask(pokeTasks.getPokeTask());
		pokeTasksInDb.setPokeTaskDescription(pokeTasks.getPokeTaskDescription());
		pokeTasksInDb.setDifficulty(pokeTasks.getDifficulty());
		pokeTasksInDb.setDate(pokeTasks.getDate());
		pokeTasksInDb.setCompletedTickBox(pokeTasks.isCompletedTickBox());

		PokeTasks updatedPokeTasks = pokeTasksRespository.save(pokeTasksInDb);

		return pokeTasksMapper.mapToDTO(updatedPokeTasks);
	}

	public boolean deletePokeTasks(Integer id) {
		if (!pokeTasksRespository.existsById(id)) {
			throw new PokeTasksNotFoundException();
		}
		pokeTasksRespository.deleteById(id);

		boolean exists = pokeTasksRespository.existsById(id);

		return !exists;
	}

}
