package edu.chl.dat076.foodfeed.model.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


@Entity
public class User implements Serializable, IEntity<String> {
    
    
    @Id
    @NotNull
    @Size(min = 1)
    private String username;
    
    @NotNull
    @Size(min = 6)
    @Pattern(regexp = "[a-zA-Z0-9_\\s\\W]")
    private String password;
    
    @OneToMany
    private List<Recipe> recipes;
    
    
    public String getUsername() {
        return username;
    }
    
    @Override
    public String getId(){
        return this.username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public List<Recipe> getRecipes() {
        return recipes;
    }
    
    public void setRecipes(List<Recipe> recipes) {
        this.recipes = recipes;
    }
    
}
