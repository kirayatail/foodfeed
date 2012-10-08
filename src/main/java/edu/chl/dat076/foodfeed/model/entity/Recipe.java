package edu.chl.dat076.foodfeed.model.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Recipe implements IEntity<Long>{

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private long id;

	private String name;
	
	private String description;
        
        @OneToMany
	private List<Ingredient> ingredients;
        
        @Override
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
