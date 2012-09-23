package edu.chl.dat076.foodfeed.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.chl.dat076.foodfeed.model.dao.RecipeDao;
import edu.chl.dat076.foodfeed.model.entity.Recipe;

/**
 * Handles requests for recipes.
 */
@Controller
@RequestMapping("/recipes")
public class RecipeController {

	private RecipeDao recipeDao;

	private static final Logger logger = LoggerFactory
			.getLogger(RecipeController.class);

	/**
	 * Shows a list of recipes
	 */
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String list(Model model) {
		List<Recipe> recipes = recipeDao.findAll();
		logger.info("Listing " + recipes.size() + " recipes.");
		model.addAttribute("recipes", recipes);
		return "recipes/list";
	}

	/**
	 * Shows a recipe
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String show(@PathVariable long id, Model model) {
		logger.info("Showing recipe with ID " + id + ".");
		model.addAttribute("recipe", recipeDao.findById(id));
		return "recipes/show";
	}

	@Autowired
	public void setRecipeDao(RecipeDao recipeDao) {
		this.recipeDao = recipeDao;
	}

}
