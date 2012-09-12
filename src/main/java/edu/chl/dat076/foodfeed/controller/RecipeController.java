package edu.chl.dat076.foodfeed.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for recipes.
 */
@Controller
@RequestMapping("/recipes")
public class RecipeController {

	private static final Logger logger = LoggerFactory
			.getLogger(RecipeController.class);

	/**
	 * Shows a list of recipes
	 */
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String list() {
		logger.info("Listing recipes.");
		return "recipes/list";
	}

	/**
	 * Shows a recipe
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String show(@PathVariable long id)  {
		logger.info("Showing recipe with ID " + id + ".");
		return "recipes/show";
	}

}
