package com.example.demo.data.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
public class PokeTasks {
	
	@Id // Auto-incrementing
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int taskId;
	
	@Column(name = "Poke-Task", unique = true)
	@NotNull
	private String pokeTask;
	
	@NotNull
	private String pokeTaskDescription;
	
	@NotNull
	@Min(0)
	@Max(10)
	private int difficulty;
	
	public PokeTasks() {
		
	}

}
