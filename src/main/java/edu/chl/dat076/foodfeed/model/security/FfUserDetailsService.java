package edu.chl.dat076.foodfeed.model.security;

import edu.chl.dat076.foodfeed.exception.ResourceNotFoundException;
import edu.chl.dat076.foodfeed.model.entity.User;
import edu.chl.dat076.foodfeed.model.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.*;

/*
 * Implements userDetailService which helps the authenticator manager to fetch user from database
 */
public class FfUserDetailsService implements UserDetailsService {

    private static final Logger log = LoggerFactory
            .getLogger(FfUserDetailsService.class);
    @Autowired
    UserService ud;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        log.info("Finding user with username " + username);

        User user;
        try {
            user = ud.find(username);
            log.info("Found user with credentials id: " + user.getId() + " pass: " + user.getPassword());
        } catch (ResourceNotFoundException exc) {
            log.error(username + " does not exist in DB");
            throw new UsernameNotFoundException(username);
        }

        return new FfUser(user.getId(), user.getPassword());
    }
}
