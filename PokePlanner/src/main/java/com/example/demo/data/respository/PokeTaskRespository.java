package com.example.demo.data.respository;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.data.model.PokeTasks;

@Repository
public interface PokeTaskRespository extends JpaRepository<PokeTasks, Integer> {

	
	@Query("SELECT t FROM PokeTasks t WHERE d.name = ?1") // Enables user to pull out tasks from with a specific variable in mind.
	public PokeTasks getPokeTaskByIdJPQL(int taskId);
	public PokeTasks getPokeTaskByNameJPQL(String pokeTask);
	public PokeTasks getPokeTaskByDescriptionJPQL(String pokeTaskDescrtiption);
	public PokeTasks getPokeTaskByDifficultyJPQL(int difficulty);
	public PokeTasks getPokeTaskByDifficultyJPQL(Date date);
	public PokeTasks getPokeTaskByCompletionJPQL(boolean completedTickBox);
	
}
