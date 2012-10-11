/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.dat076.foodfeed.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Serves Registration and view of user profiles.
 * 
 */
@Controller
@RequestMapping(value="/user/")
public class UserController {
    
    @RequestMapping(value="/", method = RequestMethod.POST)
    public String doRegister(){
        return null;
    }
    
    @RequestMapping(value="/register", method = RequestMethod.GET)
    public String getRegisterForm(){
        return null;
    }
    
    @RequestMapping(value="/{id}", method = RequestMethod.GET)
    public String show(@PathVariable long id, Model model){
        
        return null;
    }
    
    
    
}
