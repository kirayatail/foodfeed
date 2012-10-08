package edu.chl.dat076.foodfeed.model.entity;

import javax.persistence.*;

@Entity
public class Grocery {

	private String id;
	
	private String description;

	@Id
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
        
        public String toString(){
            return this.description;
        }
}
