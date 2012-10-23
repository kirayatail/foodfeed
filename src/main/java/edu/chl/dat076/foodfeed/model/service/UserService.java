package edu.chl.dat076.foodfeed.model.service;

import edu.chl.dat076.foodfeed.model.dao.IUserDao;
import edu.chl.dat076.foodfeed.model.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/*
 * A help class for communications between userDao and userController
 */
@Service("userService")
@Transactional
public class UserService {
    @Autowired
    IUserDao userDao;

    public void create(User user) {
        userDao.create(user);
    }

    public User find(String name) {
        return userDao.find(name);
    }

    public void update(User user) {
        userDao.update(user);
    }
}
