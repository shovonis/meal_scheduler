package net.therap.mealScheduler.controller;

import net.therap.mealScheduler.domain.User;
import net.therap.mealScheduler.service.UserService;
import net.therap.mealScheduler.service.UserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * @author : rifatul.islam
 * Date: 5/20/14
 * Time: 11:58 AM
 */

@WebServlet(name = "Login", urlPatterns = "/login")
public class Login extends javax.servlet.http.HttpServlet {
    private static final Logger log = LoggerFactory.getLogger(Login.class);
    private User user;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect(req.getContextPath());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("userName");
        String password = req.getParameter("password");

        if (isUserVerified(userName, password)) {
            setUpSession(req);
            log.debug("LOGIN", "USER LOG IN COMPLETED");
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
        session.setAttribute("isAdmin", user.isAdmin());
    }
}
