package edu.chl.dat076.foodfeed.controller;

import edu.chl.dat076.foodfeed.model.dao.RecipeDao;
import edu.chl.dat076.foodfeed.model.entity.Recipe;
import java.util.List;
import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Controller that handles searching for recipes.
 */
@Controller
public class SearchController {

    @Autowired
    private RecipeDao recipeDao;
    private static final Logger logger = LoggerFactory
            .getLogger(SearchController.class);

    /**
     * Simply selects the search view to render by returning its name.
     */
    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String search(Model model, @RequestParam(value = "query") String query) {

        List<Recipe> result = recipeDao.getByName(query);
        
        logger.info("Searching for a recipe");

        model.addAttribute("query", query);
        model.addAttribute("recipes", result);

        return "search/result";

    }
}
