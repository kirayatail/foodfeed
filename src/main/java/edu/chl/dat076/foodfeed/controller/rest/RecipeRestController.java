package edu.chl.dat076.foodfeed.controller.rest;

import edu.chl.dat076.foodfeed.model.dao.*;
import edu.chl.dat076.foodfeed.model.entity.*;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


/**
 * Handles requests for recipes.
 */
@Controller
@RequestMapping("rs/recipes")
public class RecipeRestController {
    
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
     * Shows a recipe
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Recipe show(@PathVariable long id) {
        logger.info("Showing recipe with ID " + id + ".");
        return  recipeDao.find(id);
    }

    /**
     * Deletes a recipe
     */
    @RequestMapping(value = "/{id}/delete", method = RequestMethod.GET)
    @ResponseBody
    public void delete(@PathVariable long id) {
        logger.info("Deleting recipe with ID " + id + ".");
        recipeDao.delete(id);
    }
}
