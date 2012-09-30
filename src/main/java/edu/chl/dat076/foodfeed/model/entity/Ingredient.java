package edu.chl.dat076.foodfeed.model.entity;

import javax.persistence.Entity;

/**
 * Specifies a separate ingredient to be used in relation to recipes.
 * 
 * TODO: Connect to some kind of quantity in order to ease conversions between units.
 * @author max
 *
 */
@Entity
public class Ingredient {

	private long id;
	
	private String name;
		

}
