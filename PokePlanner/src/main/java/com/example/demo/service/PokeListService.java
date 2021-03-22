package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.DTO.PokeListDTO;
import com.example.demo.data.model.PokeList;
import com.example.demo.data.respository.PokeListRespository;
import com.example.demo.exceptions.PokeTasksNotFoundException;
import com.example.demo.mappper.PokeListMapper;

@Service
public class PokeListService {

	private PokeListRespository pokeListRespository;

	private PokeListMapper pokeListMapper;

	@Autowired
	public PokeListService(PokeListRespository pokeListRespository, PokeListMapper pokeListMapper) {
		this.pokeListRespository = pokeListRespository;
		this.pokeListMapper = pokeListMapper;
	}

	@Transactional	
	public List<PokeListDTO> readAll() {

		List<PokeList> pokeListInDB = pokeListRespository.findAll();
		List<PokeListDTO> returnables = new ArrayList<PokeListDTO>();

		pokeListInDB.forEach(pokeList -> {

			returnables.add(pokeListMapper.mapToDTO(pokeList));
		});

		return returnables;
	}

	public PokeListDTO createPokeList(PokeList pokeList) {

		PokeList savedPokeList = pokeListRespository.save(pokeList);

		return pokeListMapper.mapToDTO(savedPokeList);
	}

	@Transactional
	public PokeListDTO updatePokeList(Integer id, PokeList pokeList) throws EntityNotFoundException {
		Optional<PokeList> pokeListInDbOpt = pokeListRespository.findById(id);
		PokeList pokeListInDb;

		if (pokeListInDbOpt.isPresent()) {
			pokeListInDb = pokeListInDbOpt.get();
		} else {
			throw new PokeTasksNotFoundException("Error - Task not found. /nPlease ensure PokeList has been created");
		}
		// Added all variables within the PokeList class excluding ID.
		pokeListInDb.setPokeList(pokeList.getPokeList());
		pokeListInDb.setPokeTasks(pokeList.getPokeTasks());

		PokeList updatedPokeList = pokeListRespository.save(pokeListInDb);

		return pokeListMapper.mapToDTO(updatedPokeList);

	}

	public Boolean deletePokeList(Integer id) {
		if (pokeListRespository.existsById(id)) {
			pokeListRespository.deleteById(id);
		} else {
			throw new EntityNotFoundException();
		}

		boolean pokeListStillExists = pokeListRespository.existsById(id);

		return !pokeListStillExists;

	}
}
