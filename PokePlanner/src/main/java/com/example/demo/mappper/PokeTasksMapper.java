package com.example.demo.mappper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.DTO.PokeTaskDTO;
import com.example.demo.data.model.PokeTasks;

@Component
public class PokeTasksMapper {

	private ModelMapper modelMapper;

	@Autowired 
	public PokeTasksMapper(ModelMapper modelMapper) {
		this.modelMapper = modelMapper;
	}
	
	public PokeTaskDTO mapToDTO(PokeTasks pokeTasks) {
		return this.modelMapper.map(pokeTasks, PokeTaskDTO.class);
	}
	private PokeTasks mapToPokeTasks(PokeTaskDTO pokeTaskDTO) {
		return this.modelMapper.map(pokeTaskDTO, PokeTasks.class);
	}
}



