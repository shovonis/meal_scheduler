package net.therap.mealScheduler.service;

import net.therap.mealScheduler.domain.User;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * @author : rifatul.islam
 * Date: 5/20/14
 * Time: 12:31 PM
 */
public interface UserService {
    public User getUser(String userName, String password);

    public List<User> getAllUser();

    public void addUser(User user);
}
