package com.example.demo.data.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.data.model.PokeTasks;

@Repository
public interface PokeTaskRespository extends JpaRepository<PokeTasks, Integer> {

	
	@Query("SELECT t FROM PokeTasks t WHERE t.taskId = ?1") // Enables user to pull out tasks from with a specific variable in mind.
	public PokeTasks getPokeTaskByIdJPQL(int taskId);
	
	
/*	@Query("SELECT * FROM PokeTasks t")
	public PokeTasks */
	
/*	
	public List<PokeTasks> getPokeTaskByPokeTask(String pokeTask);
	public PokeTasks getPokeTaskByDescription(String pokeTaskDescrtiption);
	public PokeTasks getPokeTaskByDifficulty(int difficulty);
	public PokeTasks getPokeTaskByDifficulty(String date);
	public PokeTasks getPokeTaskByCompletion(boolean completedTickBox); */
	
//	public boolean existsByName(String name);


}
