/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.dat076.foodfeed.model.dao;

import edu.chl.dat076.foodfeed.exception.ResourceNotFoundException;
import edu.chl.dat076.foodfeed.model.entity.User;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * @author max
 */
@Repository("userDao")
public class MockUserDao implements IUserDao{
    
    public List<User> users;
    
    public MockUserDao(){
        users = new ArrayList<>();
    }
    
    @Override
    public void create(User t) {
        boolean exists = false;
        for(User u:users){
            if(u.getId().equals(t.getId())){
                exists = true;
            }
        }
        if(!exists){
            users.add(t);
        }
    }

    @Override
    public void delete(User t) {
        users.remove(t);
    }

    @Override
    public void delete(String id) {
        for(User u:users){
            if(u.getId().equals(users)){
                users.remove(u);
            }
        }
    }

    @Override
    public User find(String id) {
        for(User u:users){
            if(u.getId().equals(id)){
                return u;
            }
        }
        throw new ResourceNotFoundException();
    }

    @Override
    public List<User> findAll() {
        return users;
    }

    @Override
    public void update(User t) {
        User old = find(t.getId());
        
        users.remove(old);
        users.add(t);        
    }
    
    public void clear(){
        users.clear();
    }
    
}
