package com.example.demo.data.model;

import java.util.Date;

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
	
	@NotNull
	private Date completionDate; 
	
	public PokeTasks() {
		
	}
	
	public PokeTasks(String pokeTask, String pokeTaskDescription, int difficulty, Date completionDate) {
		super();
		this.pokeTask = pokeTask;
		this.pokeTaskDescription = pokeTaskDescription;
		this.difficulty = difficulty;
		this.completionDate = completionDate; 
		
	}
	
	public PokeTasks(int taskId, String pokeTask, String pokeTaskDescription, int difficulty, Date completionDate) {
		super();
		this.taskId = taskId;
		this.pokeTask = pokeTask;
		this.pokeTaskDescription = pokeTaskDescription;
		this.difficulty = difficulty;
		this.completionDate = completionDate; 
		
}

	public int getTaskId() {
		return taskId;
	}

	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}

	public String getPokeTask() {
		return pokeTask;
	}

	public void setPokeTask(String pokeTask) {
		this.pokeTask = pokeTask;
	}

	public String getPokeTaskDescription() {
		return pokeTaskDescription;
	}

	public void setPokeTaskDescription(String pokeTaskDescription) {
		this.pokeTaskDescription = pokeTaskDescription;
	}

	public int getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(int difficulty) {
		this.difficulty = difficulty;
	}

	public Date getCompletionDate() {
		return completionDate;
	}

	public void setCompletionDate(Date completionDate) {
		this.completionDate = completionDate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((completionDate == null) ? 0 : completionDate.hashCode());
		result = prime * result + difficulty;
		result = prime * result + ((pokeTask == null) ? 0 : pokeTask.hashCode());
		result = prime * result + ((pokeTaskDescription == null) ? 0 : pokeTaskDescription.hashCode());
		result = prime * result + taskId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PokeTasks other = (PokeTasks) obj;
		if (completionDate == null) {
			if (other.completionDate != null)
				return false;
		} else if (!completionDate.equals(other.completionDate))
			return false;
		if (difficulty != other.difficulty)
			return false;
		if (pokeTask == null) {
			if (other.pokeTask != null)
				return false;
		} else if (!pokeTask.equals(other.pokeTask))
			return false;
		if (pokeTaskDescription == null) {
			if (other.pokeTaskDescription != null)
				return false;
		} else if (!pokeTaskDescription.equals(other.pokeTaskDescription))
			return false;
		if (taskId != other.taskId)
			return false;
		return true;
	}

}
