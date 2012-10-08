package edu.chl.dat076.foodfeed.model.entity;

import javax.persistence.*;

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
	
	private Grocery grocery;
		
	private double amount;
	private String unit;
	
	@Id
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Grocery getGrocery() {
		return grocery;
	}
	public void setGrocery(Grocery grocery) {
		this.grocery = grocery;
	}

	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
        
        public String toString(){
            return grocery.toString()+" "+String.format("%.2f", this.amount)+" "+unit;
        }

}
