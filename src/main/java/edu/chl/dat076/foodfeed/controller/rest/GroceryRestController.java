/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.dat076.foodfeed.controller.rest;

import edu.chl.dat076.foodfeed.model.dao.GroceryDao;
import edu.chl.dat076.foodfeed.model.entity.Grocery;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * REST controller for groceries.
 * 
 */
@Controller
public class GroceryRestController {

    @Autowired
    private GroceryDao groceryDao;
    private static final Logger logger = LoggerFactory
            .getLogger(GroceryRestController.class);

    @RequestMapping(value = "", method = RequestMethod.GET)
    @ResponseBody
    public List<Grocery> getGrocery(String name) {
        return groceryDao.getGrocery(name);
    }
}
