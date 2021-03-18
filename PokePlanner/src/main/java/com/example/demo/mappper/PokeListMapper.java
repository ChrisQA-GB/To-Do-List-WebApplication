package com.example.demo.mappper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.DTO.PokeListDTO;
import com.example.demo.data.model.PokeList;

@Component
public class PokeListMapper {
	
	private ModelMapper modelMapper;
	
	@Autowired
	public PokeListMapper(ModelMapper modelMapper) {
		this.modelMapper = modelMapper;
	}
	
	public PokeListDTO mapToDTO(PokeList pokeList) {
		return this.modelMapper.map(pokeList, PokeListDTO.class);
	}

	public PokeList mapToPokeList(PokeListDTO pokeListDTO) {
		return this.modelMapper.map(pokeListDTO, PokeList.class);
	}
}
