/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.dat076.foodfeed.controller.rest;

import edu.chl.dat076.foodfeed.model.dao.IUserDao;
import edu.chl.dat076.foodfeed.model.entity.User;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Rest controller for users.
 * 
 */
@Controller
@RequestMapping("rs/user")
public class UserRestController {
    
    @Autowired
    private IUserDao userDao;
    
    private static final Logger logger = LoggerFactory
            .getLogger(UserRestController.class);
    
    
    @RequestMapping(value = "", method = RequestMethod.GET)
    @ResponseBody // IMPORTANT! declares that the returned object is the ACTUAL thing to return
                  // and not a reference to a jspx page. JSON will be created through black magic.
    public List<User> getAll(){
        return userDao.findAll();
    }
    
    @RequestMapping(value = "/name/{id}", method = RequestMethod.GET)
    @ResponseBody
    public User getByID(@PathVariable String id){
        return userDao.find(id);
    }
}
