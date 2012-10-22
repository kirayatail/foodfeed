
package edu.chl.dat076.foodfeed.model.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Recipe implements IEntity<Long>, Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @NotNull
    @Size(min = 1, message = "The name must consist of at least one character")
    private String name;
    @NotNull
    @Size(min = 1, message = "The description must consist of at least one character")
    private String description;
    @NotNull
    @Size(min = 1, message = "The instructions must consist of at least one character")
    private String instructions;
    @OneToMany(cascade = {CascadeType.ALL})
    @Valid
    private List<Ingredient> ingredients;
    
    public Recipe() {
        this.ingredients = new ArrayList<>();
    }

    public Recipe(String name, String description, String instructions, List<Ingredient> ingredients) {
        this.name = name;
        this.description = description;
        this.instructions = instructions;
        this.ingredients = ingredients;
    }
    
    @Override
    public Long getId() {
        return id;
    }

    @Override
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
    
    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }
       
    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }
    
    public int getIngredientCount() {
        if (this.ingredients != null) {
            return ingredients.size();
        } else {
            return 0;
        }
    }
}
