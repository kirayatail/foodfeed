package edu.chl.dat076.foodfeed.model.dao;

import edu.chl.dat076.foodfeed.model.entity.Recipe;
import org.springframework.stereotype.Repository;

@Repository("recipeDao")
public class RecipeDao extends AbstractDao<Recipe, Long> {

    RecipeDao() {
        super(Recipe.class);
    }
}
