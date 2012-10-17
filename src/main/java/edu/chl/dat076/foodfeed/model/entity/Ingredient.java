package edu.chl.dat076.foodfeed.model.entity;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

/**
 * Specifies a separate ingredient to be used in relation to recipes.
 *
 * TODO: Connect to some kind of quantity in order to ease conversions between
 * units.
 */
@Entity
public class Ingredient implements IEntity<Long>, Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne(cascade = CascadeType.ALL)
    private Grocery grocery;
    @Min(value = 0, message = "Value must be positive")
    @NumberFormat(style= Style.NUMBER)
    private Double amount;
    private String unit;

    @Override
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Grocery getGrocery() {
        return grocery;
    }

    public void setGrocery(Grocery grocery) {
        this.grocery = grocery;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    @NotNull
    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }
    
    public String getName() {
        return this.grocery.getId();
    }

    @Override
    public String toString() {
        return grocery.toString() + " " + String.format("%.2f", this.amount) + " " + unit;
    }
}
