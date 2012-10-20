/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.dat076.foodfeed.controller.rest;

import edu.chl.dat076.foodfeed.model.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Rest controller for users.
 * 
 */
@Controller
@RequestMapping(value="rs/user")
public class UserRestController {
    
    @RequestMapping(value = "", method = RequestMethod.GET)
    @ResponseBody // IMPORTANT! declares that the returned object is the ACTUAL thing to return
                  // and not a reference to a jspx page
    public User getSample(){
        User usr = new User("imax","badanka");
        
        return usr;
    }    
}
