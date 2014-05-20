package net.therap.mealScheduler.controller;

import net.therap.mealScheduler.domain.User;
import net.therap.mealScheduler.service.UserService;
import net.therap.mealScheduler.service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: rifatul.islam
 * Date: 5/20/14
 * Time: 11:58 AM
 * To change this template use File | Settings | File Templates.
 */

@WebServlet(name = "Login", urlPatterns = "/login")
public class Login extends javax.servlet.http.HttpServlet {
    private User user;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("userName");
        String password = req.getParameter("password");

        if (isUserVerified(userName, password)) {
            setUpSession(req);
            resp.sendRedirect(req.getContextPath() + "/home");
        } else {
            resp.sendRedirect(req.getContextPath());
        }
    }

    private boolean isUserVerified(String userName, String password) {
        UserService userService = new UserServiceImpl();
        user = userService.getUser(userName, password);
        return user != null;
    }

    private void setUpSession(HttpServletRequest req) {
        HttpSession session = req.getSession(false);
        session.setAttribute("user", user);
        session.setAttribute("authenticatedUser", true);
    }
}
