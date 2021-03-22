package com.example.demo.DTO;

import java.util.List;

public class PokeListDTO {
	
	private int pokeListId;
	
	private String pokeList;
	
	private List<PokeTaskDTO> pokeTasks;

	public PokeListDTO() {

	}

	public PokeListDTO(int pokeListId, String pokeList, List<PokeTaskDTO> pokeTasks) {
		super();
		this.pokeListId = pokeListId;
		this.pokeList = pokeList;
		this.pokeTasks = pokeTasks;
	}

	
	public PokeListDTO(String pokeList) {
		super();
		this.pokeList = pokeList;
	}
	
	public int getPokeListId() {
		return pokeListId;
	}
	
	

	public void setPokeListId(int pokeListId) {
		this.pokeListId = pokeListId;
	}

	public String getPokeList() {
		return pokeList;
	}

	public void setPokeList(String pokeList) {
		this.pokeList = pokeList;
	}

	public List<PokeTaskDTO> getPokeTasks() {
		return pokeTasks;
	}

	public void setPokeTasks(List<PokeTaskDTO> pokeTasks) {
		this.pokeTasks = pokeTasks;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((pokeList == null) ? 0 : pokeList.hashCode());
		result = prime * result + pokeListId;
		result = prime * result + ((pokeTasks == null) ? 0 : pokeTasks.hashCode());
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
		PokeListDTO other = (PokeListDTO) obj;
		if (pokeList == null) {
			if (other.pokeList != null)
				return false;
		} else if (!pokeList.equals(other.pokeList))
			return false;
	if (pokeListId != other.pokeListId)
			return false;  
		if (pokeTasks == null) {
			if (other.pokeTasks != null)
				return false;
		} else if (!pokeTasks.equals(other.pokeTasks))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PokeListDTO [pokeListId=" + pokeListId + ", pokeList=" + pokeList + ", pokeTasks=" + pokeTasks + "]";
	}
	
	
	
	
	

}
