/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.dat076.foodfeed.services;

import edu.chl.dat076.foodfeed.exception.ResourceNotFoundException;
import edu.chl.dat076.foodfeed.model.dao.UserDao;
import edu.chl.dat076.foodfeed.model.entity.User;
import edu.chl.dat076.foodfeed.model.security.FfUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 *
 * @author max
 */
public class FfUserDetailsService implements UserDetailsService {
    
    @Autowired
    UserDao ud;
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User usr;
        try {
            usr = ud.find(username);
        } catch(ResourceNotFoundException exc){
            throw new UsernameNotFoundException(username);            
        }
        
        return new FfUser(usr.getId(), usr.getPassword());
    }
    
}
