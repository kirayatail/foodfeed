package edu.chl.dat076.foodfeed.model.service;

import edu.chl.dat076.foodfeed.model.dao.*;
import edu.chl.dat076.foodfeed.model.entity.*;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/*
 * A help class for communication between recipeDao and recipeController
 */
@Service("recipeService")
@Transactional
public class RecipeService {

    @Autowired
    private RecipeDao recipeDao;
    @Autowired
    private IUserDao userDao;

    public List<Recipe> findAll() {
        return recipeDao.findAll();
    }

    public void create(Recipe recipe, User user) {
        recipe.setUser(user);
        recipeDao.create(recipe);
    }

    public Recipe find(long id) {
        return recipeDao.find(id);
    }

    public void update(Recipe recipe) {
        recipeDao.update(recipe);
    }

    public void delete(Recipe recipe) {
        User user = recipe.getUser();
        user.getRecipes().remove(recipe);
        userDao.update(user);
        recipeDao.delete(recipe);
    }
}
