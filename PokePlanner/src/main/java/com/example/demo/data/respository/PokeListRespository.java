package com.example.demo.data.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.data.model.PokeList;

public interface PokeListRespository extends JpaRepository<PokeList, Integer> {
	
	@Query("SELECT l FROM PokeList l WHERE l.pokeListId = ?1") // Enables user to pull out tasks from with a specific variable in mind.
	public PokeList getPokeListByIdJPQL(int pokeListId);
	

}
