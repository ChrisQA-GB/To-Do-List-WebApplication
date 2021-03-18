package com.example.demo.DTO;

import java.util.List;

import com.example.demo.data.model.PokeList;
import com.example.demo.data.model.Status;

public class PokeTaskDTO {
	
	private int taskId;
	
//	private PokeList pokeList; 
	
	private String pokeTask;
	
	private String pokeTaskDescription;
	
	private int difficulty; 
	
	private String date;
	
	private boolean completedTickBox;
	
	private Status status; 
	
//	private List<PokeTaskDTO> pokeTaskDTO;

	public PokeTaskDTO() {
	
	}

	public PokeTaskDTO(int taskId, String pokeTask, String pokeTaskDescription, int difficulty,
			String date, boolean completedTickBox) {
		super();
		
		this.taskId = taskId;
//		this.pokeList = pokeList;
		this.pokeTask = pokeTask;
		this.pokeTaskDescription = pokeTaskDescription;
		this.difficulty = difficulty;
		this.date = date;
		this.completedTickBox = completedTickBox;
	}

	public PokeTaskDTO(int taskId, String pokeTask, String pokeTaskDescription, int difficulty,
			String date, boolean completedTickBox, Status status) {
		
		super();
		this.taskId = taskId;
//		this.pokeList = pokeList; Keeping this in as a comment to remind myself of the massive error this caused
		this.pokeTask = pokeTask;
		this.pokeTaskDescription = pokeTaskDescription;
		this.difficulty = difficulty;
		this.date = date;
		this.completedTickBox = completedTickBox;
		this.status = status;
//		this.pokeTaskDTO = pokeTaskDTO;
	}

	public int getTaskId() {
		return taskId;
	}

	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}

//	public PokeList getPokeList() {
//		return pokeList;
//	}
//
//	public void setPokeList(PokeList pokeList) {
//		this.pokeList = pokeList;
//	}

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
		PokeTaskDTO other = (PokeTaskDTO) obj;
		if (completedTickBox != other.completedTickBox)
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
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
		if (status != other.status)
			return false;
		if (taskId != other.taskId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PokeTaskDTO [taskId=" + taskId + ", pokeTask=" + pokeTask + ", pokeTaskDescription="
				+ pokeTaskDescription + ", difficulty=" + difficulty + ", date=" + date + ", completedTickBox="
				+ completedTickBox + ", status=" + status + "]";
	}

}
