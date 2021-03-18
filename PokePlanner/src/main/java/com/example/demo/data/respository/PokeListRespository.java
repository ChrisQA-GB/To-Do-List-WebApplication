package com.example.demo.data.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.data.model.PokeList;

public interface PokeListRespository extends JpaRepository<PokeList, Integer> {
	
	
	

}
