package com.example.demo.data.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity 
public class PokeList {
	
	@Id // Auto-incrementing
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int pokeListId;
	
	@Column(name = "PokeList", unique = true)
	@NotNull
	private String pokeList;
	
	
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((pokeList == null) ? 0 : pokeList.hashCode());
		result = prime * result + pokeListId;
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
		return true;
	}
	
	
	
	

}	
