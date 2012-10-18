/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.dat076.foodfeed.services;

import edu.chl.dat076.foodfeed.exception.ResourceNotFoundException;
import edu.chl.dat076.foodfeed.model.dao.UserDao;
import edu.chl.dat076.foodfeed.model.entity.User;
import edu.chl.dat076.foodfeed.model.security.FfUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 *
 * @author max
 */
public class FfUserDetailsService implements UserDetailsService {
    
     private static final Logger log = LoggerFactory
            .getLogger(FfUserDetailsService.class);
    
    @Autowired
    UserDao ud;
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        
        log.info("Finding user with username "+username);
        
        User usr;
        try {
            usr = ud.find(username);
            log.info("Found user with credentials id: "+usr.getId()+" pass: "+usr.getPassword());
        } catch(ResourceNotFoundException exc){
            log.error(username+" does not exist in DB");
            throw new UsernameNotFoundException(username);            
        }
        
        return new FfUser(usr.getId(), usr.getPassword());
    }
    
}
