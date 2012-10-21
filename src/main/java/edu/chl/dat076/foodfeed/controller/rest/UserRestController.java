/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.dat076.foodfeed.controller.rest;

import edu.chl.dat076.foodfeed.model.dao.UserDao;
import edu.chl.dat076.foodfeed.model.entity.User;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    private UserDao userDao;
    
    private static final Logger logger = LoggerFactory
            .getLogger(UserRestController.class);
    
    
    @RequestMapping(value = "", method = RequestMethod.GET)
    @ResponseBody // IMPORTANT! declares that the returned object is the ACTUAL thing to return
                  // and not a reference to a jspx page. JSON will be created through black magic.
    public List<User> getAll(){
        
        /*
         * Here's the point where all users would have their passwords removed 
         * before sending them to the response
         */
        
        return userDao.findAll();
    }
    
    @RequestMapping(value = "/name/{id}", method = RequestMethod.GET)
    @ResponseBody
    public User getByID(@PathVariable String id){
        
        /*
         * Place for a check to see if the password should be sent or not
         * (maybe never send passwords, regardless of logged in or not?)
         */
        return userDao.find(id);
    }
    
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public void register(@RequestParam("username") String username, @RequestParam("password") String pass){
        User usr = new User(username, pass);
        userDao.create(usr);
        
    }
}
