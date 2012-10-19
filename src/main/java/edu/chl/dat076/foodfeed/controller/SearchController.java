/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.dat076.foodfeed.controller;

import edu.chl.dat076.foodfeed.model.dao.RecipeDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class SearchController {

    @Autowired
    private RecipeDao recipeDao;
    private static final Logger logger = LoggerFactory
            .getLogger(SearchController.class);

    /**
     * Simply selects the home view to render by returning its name.
     */
    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String search(Model model, @RequestParam(value="query") String query) {
        
        //recipeDao.getByName(query);
        
        model.addAttribute("query", query);
        
        return "search/result";

    }
}
