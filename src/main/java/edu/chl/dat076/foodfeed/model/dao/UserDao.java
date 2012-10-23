package edu.chl.dat076.foodfeed.model.dao;

import edu.chl.dat076.foodfeed.model.entity.User;
import edu.chl.dat076.foodfeed.util.EncoderUtil;
import org.springframework.stereotype.Repository;

/*
 * Implements CRUD specific to the entity User
 */
@Repository("userDao")
public class UserDao extends AbstractDao<User, String> implements IUserDao {

    public UserDao() {
        super(User.class);
    }

    @Override
    public void create(User u) {
        u.setPassword(EncoderUtil.encode(u.getPassword()));
        super.create(u);
    }
}
