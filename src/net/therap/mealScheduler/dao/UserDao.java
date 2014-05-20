package net.therap.mealScheduler.dao;

import net.therap.mealScheduler.domain.User;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: rifatul.islam
 * Date: 5/20/14
 * Time: 12:01 PM
 * To change this template use File | Settings | File Templates.
 */
public interface UserDao {
    public User getUser(String userName, String password);

    public List<User> getAllUser();

    public void addUser(User user);
}
