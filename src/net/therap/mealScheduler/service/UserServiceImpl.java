package net.therap.mealScheduler.service;

import net.therap.mealScheduler.dao.UserDao;
import net.therap.mealScheduler.dao.UserDaoImpl;
import net.therap.mealScheduler.domain.User;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: rifatul.islam
 * Date: 5/20/14
 * Time: 12:33 PM
 * To change this template use File | Settings | File Templates.
 */
public class UserServiceImpl implements UserService {
    private UserDao userDao = null;

    public UserServiceImpl() {
        this.userDao = new UserDaoImpl();
    }

    @Override
    public User getUser(String userName, String password) {
        return userDao.getUser(userName,password);
    }

    @Override
    public List<User> getAllUser() {
        return null;
    }

    @Override
    public void addUser(User user) {
    }
}
