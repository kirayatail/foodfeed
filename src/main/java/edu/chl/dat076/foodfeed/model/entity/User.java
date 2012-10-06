package edu.chl.dat076.foodfeed.model.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;


@Entity
public class User implements Serializable {
    
    
    @Id
    private String username;
    
    private String password;
    
    @OneToMany
    private List<Recipe> recipes;
    
    
    public String getUsername() {
        return username;
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
