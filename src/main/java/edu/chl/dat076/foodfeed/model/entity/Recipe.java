package edu.chl.dat076.foodfeed.model.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Recipe implements IEntity<Long>, Serializable{

        private long id;
        
        private String name;

        private String description;

        private List<Ingredient> ingredients;
        
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Override
        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        @NotNull
        @Size(min = 1, message = "The name must consist of at least one character")
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
        
        @NotNull
        @Size(min = 1, message = "The description must consist of at least one character")
        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        @OneToMany
        public List<Ingredient> getIngredients() {
            return ingredients;
        }

        public void setIngredients(List<Ingredient> ingredients) {
            this.ingredients = ingredients;
        }
       
}
