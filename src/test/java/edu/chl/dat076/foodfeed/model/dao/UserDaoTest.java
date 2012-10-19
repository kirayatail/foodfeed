/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.chl.dat076.foodfeed.model.dao;

import edu.chl.dat076.foodfeed.exception.ResourceNotFoundException;
import edu.chl.dat076.foodfeed.model.entity.User;
import java.util.List;
import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Kohina
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
    "classpath*:spring/root-context.xml",
    "classpath*:spring/security-context.xml"})
@Transactional
public class UserDaoTest {
    
    @Autowired
    UserDao userDao;
    
    public User user;

    /*
     * Creates a User Object to be used in tests
     */
    private User createTestUserObject(){
        return new User("Admin", "testpass");
    }
    
    @Before
    public void createUser(){
        user = createTestUserObject();
        userDao.create(user);
    }
    
    @Test
    public void testCreate(){
        Assert.assertNotNull("recipe could not be created", user.getId());
    }
    
    @Test(expected = ResourceNotFoundException.class)
    public void testDelete(){
        userDao.delete(user);
        Assert.assertNull("recipe removed", userDao.find(user.getId()));
    }
    
    @Test(expected = ResourceNotFoundException.class)
    public void testDeleteID(){
        userDao.delete(user.getId());
        Assert.assertNull("recipe not removed", userDao.find(user.getId()));
    }
    
    @Test
    public void testFind(){
        User result = userDao.find(user.getId());
        Assert.assertNotNull("recipe not found", result);
    }
    
    @Test
    public void testFindAll() {
        List<User> users = userDao.findAll();
        Assert.assertFalse("Check that true is true", users.isEmpty());
    }
    
    @Test
    public void testUpdate(){
        User old = new User();
        old.setId(user.getId());
        user.setId("New name");
        userDao.update(user);
        Assert.assertNotSame("Recipe not updated", user.getId(), old.getId());
    }
}
