package edu.chl.dat076.foodfeed.controller.rest;

import edu.chl.dat076.foodfeed.model.dao.*;
import edu.chl.dat076.foodfeed.model.entity.*;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


/**
 * Handles requests for recipes.
 */
@Controller
@RequestMapping("rs/recipes")
public class RecipeRestController {
    
    @Autowired
    private UserDao userDao;
    
    @Autowired
    private RecipeDao recipeDao;
    private static final Logger logger = LoggerFactory
            .getLogger(edu.chl.dat076.foodfeed.controller.RecipeController.class);

    /**
     * Shows a list of recipes
     */
    @RequestMapping(value = "", method = RequestMethod.GET)
    @ResponseBody
    public List<Recipe> list() {
        List<Recipe> recipes = recipeDao.findAll();
        logger.info("Listing " + recipes.size() + " recipes.");
        return recipes;
    }
    
    /**
     * Creates a recipe
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @Secured("ROLE_USER")
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public void add(@RequestParam("recipe") Recipe recipe) {
        logger.info("Saving a new recipe.");
        
        User activeUser = userDao.find(SecurityContextHolder.getContext().getAuthentication().getName());
        
        if(activeUser.getRecipes() == null){
            activeUser.setRecipes(new ArrayList<Recipe>());
        }
        activeUser.getRecipes().add(recipe);
        
        recipeDao.create(recipe);
        userDao.update(activeUser);
    }

    /**
     * Adds another ingredient to a recipe.
     */
    @RequestMapping(value = "/addIn", method = RequestMethod.POST)
    @Secured("ROLE_USER")
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public void addIngredient(@RequestParam("recipe") Recipe recipe) {
        logger.info("Adding another ingredient.");
        recipe.getIngredients().add(new Ingredient());
    }

    /**
     * Removes an ingredient from a recipe.
     */
    @RequestMapping(value = "/addRemIn", method = RequestMethod.POST)
    @Secured("ROLE_USER")
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public void removeIngredient(@RequestParam("recipe") Recipe recipe,
            @RequestParam("remove-ingredient") int index) {
        logger.info("Removing ingredient att index " + index + ".");
        recipe.getIngredients().remove(index);
    }

    /**
     * Shows a recipe
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Recipe show(@PathVariable long id) {
        logger.info("Showing recipe with ID " + id + ".");
        return  recipeDao.find(id);
    }

    /**
     * Edits a recipe
     */
    @RequestMapping(value = "/{id}/editSave", method = RequestMethod.POST)
    @Secured("ROLE_USER")
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public void edit(@RequestParam("recipe") Recipe recipe) {
        logger.info("Updating recipe with ID " + recipe.getId() + ".");
        recipeDao.update(recipe);
    }

    /**
     * Deletes a recipe
     */
    @RequestMapping(value = "/{id}/delete", method = RequestMethod.GET)
    @ResponseBody
    public void delete(@PathVariable long id) {
        logger.info("Deleting recipe with ID " + id + ".");
        recipeDao.delete(id);;
    }
}
