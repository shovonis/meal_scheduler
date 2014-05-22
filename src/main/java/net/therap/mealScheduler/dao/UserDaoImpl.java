package net.therap.mealScheduler.dao;

import net.therap.mealScheduler.domain.User;
import net.therap.mealScheduler.util.DatabaseTemplate;
import net.therap.mealScheduler.util.ObjectRowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * @author : rifatul.islam
 * Date: 5/20/14
 * Time: 12:04 PM
 */
public class UserDaoImpl implements UserDao {
    @Override
    public User getUser(String userName, String password) {
        String query = "SELECT * FROM user WHERE user_name= ? AND password = ?";

        List<User> userList = DatabaseTemplate.queryForObject(new ObjectRowMapper<User>() {
            @Override
            public User mapRowToObject(ResultSet resultSet) throws SQLException {
                return setUser(resultSet);
            }
        }, query, userName, password);

        if (userList.size() != 0) {
            return userList.get(0);
        }
        return null;
    }

    @Override
    public List<User> getAllUser() {
        String query = "SELECT * FROM user";
        List<User> userList = DatabaseTemplate.queryForObject(new ObjectRowMapper<User>() {
            @Override
            public User mapRowToObject(ResultSet resultSet) throws SQLException {
                return setUser(resultSet);
            }
        }, query);

        return userList;
    }

    @Override
    public void addUser(User user) {

    }

    private User setUser(ResultSet resultSet) throws SQLException {
        User user = new User();
        user.setUserId(resultSet.getInt("user_id"));
        user.setUserName(resultSet.getString("user_name"));
        user.setEmail(resultSet.getString("email"));
        user.setPassword(resultSet.getString("password"));
        user.setAdmin(resultSet.getInt("admin"));
        return user;
    }
}
