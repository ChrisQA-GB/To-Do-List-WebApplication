package com.example.demo.data.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity 
public class PokeList {
	
	@Id // Auto-incrementing
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int pokeListId;
	
	@Column(name = "PokeList", unique = true)
	@NotNull
	private String pokeList;
	
	@OneToMany(mappedBy = "PokeList", fetch = FetchType.LAZY, orphanRemoval = true)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private List<PokeTasks> pokeTasks;
	
	
	public PokeList() {
		
	}
	
	public PokeList(String pokeList) {
		super();
		this.pokeList = pokeList;
	}
	
	public PokeList(int pokeListId, String pokeList)  {
		super();
		this.pokeListId = pokeListId;
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

	public List<PokeTasks> getPokeTasks() {
		return pokeTasks;
	}

	public void setPokeTasks(List<PokeTasks> pokeTasks) {
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
		PokeList other = (PokeList) obj;
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
	


	
	

}	
