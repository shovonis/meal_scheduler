package net.therap.mealScheduler.domain;

/**
 * Created with IntelliJ IDEA.
 * User: rifatul.islam
 * Date: 5/20/14
 * Time: 12:00 PM
 * To change this template use File | Settings | File Templates.
 */
public class User {
    private Integer userId;
    private String userName;
    private String email;
    private String password;
    private int admin;
    private boolean isAdmin;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAdmin() {
        return admin;
    }

    public void setAdmin(int admin) {
        this.admin = admin;
    }

    public boolean isAdmin() {
        if (admin == 1) {
            return isAdmin = true;
        }
        return isAdmin;
    }
}
