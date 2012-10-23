/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.dat076.foodfeed.controller;

import edu.chl.dat076.foodfeed.mock.Model;
import edu.chl.dat076.foodfeed.mock.Result;
import edu.chl.dat076.foodfeed.model.dao.IUserDao;
import edu.chl.dat076.foodfeed.model.dao.MockUserDao;
import edu.chl.dat076.foodfeed.model.entity.User;
import edu.chl.dat076.foodfeed.model.service.UserService;
import junit.framework.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.test.util.ReflectionTestUtils;

/**
 *
 * @author max
 */
public class UserControllerTest {
    
    MockUserDao userDao;
    UserService uService;
    UserController uc;
    Result result;
    Model model;
    
    public UserControllerTest() {
        userDao = new MockUserDao();
        uService= new UserService();
    }
    
    @Before
    public void buildUp(){
        userDao.create(new User("adam", "bertil"));
        userDao.create(new User("bertil", "cesar"));
        uc = new UserController();
        ReflectionTestUtils.setField(uService, "userDao", userDao, IUserDao.class);
        ReflectionTestUtils.setField(uc,"userService", uService, UserService.class);
        result = new Result();
        model = new Model();
    }
    
    @After
    public void tearDown(){
        userDao.clear();
    }
    
    @Test
    public void testShowRegisterForm(){
        
        String path = uc.getRegisterForm(model);
        
        Assert.assertEquals("Returned path", "user/register", path);
        
        Assert.assertTrue("Model contains key user", model.map.containsKey("user"));
        User user = (User) model.map.get("user");
        
        Assert.assertEquals("Username empty", null, user.getUsername());
    }
    
    @Test
    public void testRegisterUser(){
        User usr = new User("test", "hemligt");
        uc.doRegister(model, usr, result);
        
        Assert.assertTrue("User exists in DAO", userDao.users.contains(usr));
    }
    
    @Test
    public void testRegisterUserWithErrors(){
        
    }
    
    @Test
    public void testGetSingleUser(){
        // Show, not list
    }
    
    @Test
    public void testListMultipleUsers(){
        
    }
}
