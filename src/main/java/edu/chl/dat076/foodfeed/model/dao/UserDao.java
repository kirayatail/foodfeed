
package edu.chl.dat076.foodfeed.model.dao;

import edu.chl.dat076.foodfeed.model.entity.User;

/**
 *
 * 
 */
public class UserDao extends AbstractDao<User, Long> {
    
    public UserDao(){
        super(User.class);
    }    
}
