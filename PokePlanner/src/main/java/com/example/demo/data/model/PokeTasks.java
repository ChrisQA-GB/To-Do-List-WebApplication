package com.example.demo.data.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
public class PokeTasks {
	
	@Id // Auto-incrementing
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int taskId; // Auto-Generated Task Id for filteration
	
	@ManyToOne(targetEntity = PokeList.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_pokelist_id") // indicates the PokeList class as the owner of the PokeList-PokeTask relationship
//	@JsonBackReference // alternate way of solving recursion without a DTO
	private PokeList pokeList;
	
	
	@Column(name = "poke_task")
	@NotNull
	private String pokeTask; // Title of their Task  
	
	@NotNull
	private String pokeTaskDescription; // User writes brief of what their task is
	
	@NotNull
	@Min(0)
	@Max(10)
	private int difficulty; // User can set how hard their task is 0 being lowest difficulty, 10 being highest.
	
	
	private String date; // Goal is to create String and tickbox variables within my table.
	
	
	private boolean completedTickBox; // This would be for creating the tickbox (May move to a new class, TaskDetails?
	
	private Status status; 
	
	
	public PokeTasks() {
		}

	public PokeTasks(int taskId, PokeList pokeList,  String pokeTask, String pokeTaskDescription,
			 int difficulty, String date, boolean completedTickBox, Status status) {
		super();
		this.taskId = taskId;
		this.pokeList = pokeList;
		this.pokeTask = pokeTask;
		this.pokeTaskDescription = pokeTaskDescription;
		this.difficulty = difficulty;
		this.date = date;
		this.completedTickBox = completedTickBox;
		this.status = status;
	}

	public PokeTasks(PokeList pokeList, String pokeTask, String pokeTaskDescription,
			int difficulty, String String, boolean completedTickBox, Status status) {
		super();
		this.pokeList = pokeList;
		this.pokeTask = pokeTask;
		this.pokeTaskDescription = pokeTaskDescription;
		this.difficulty = difficulty;
		this.date = date;
		this.completedTickBox = completedTickBox;
		this.status = status;
	}

	public int getTaskId() {
		return taskId;
	}

	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}

	public PokeList getPokeList() {
		return pokeList;
	}

	public void setPokeList(PokeList pokeList) {
		this.pokeList = pokeList;
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

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public boolean isCompletedTickBox() {
		return completedTickBox;
	}

	public void setCompletedTickBox(boolean completedTickBox) {
		this.completedTickBox = completedTickBox;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (completedTickBox ? 1231 : 1237);
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + difficulty;
		result = prime * result + ((pokeList == null) ? 0 : pokeList.hashCode());
		result = prime * result + ((pokeTask == null) ? 0 : pokeTask.hashCode());
		result = prime * result + ((pokeTaskDescription == null) ? 0 : pokeTaskDescription.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
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
		if (completedTickBox != other.completedTickBox)
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (difficulty != other.difficulty)
			return false;
		if (pokeList == null) {
			if (other.pokeList != null)
				return false;
		} else if (!pokeList.equals(other.pokeList))
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
		if (status != other.status)
			return false;
		if (taskId != other.taskId)
			return false;
		return true;
	}

}
		
	