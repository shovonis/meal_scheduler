package net.therap.mealScheduler.controller;

import net.therap.mealScheduler.domain.User;
import net.therap.mealScheduler.service.UserService;
import net.therap.mealScheduler.service.UserServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user;
        String userName = req.getParameter("userName");
        String password = req.getParameter("password");

        UserService userService = new UserServiceImpl();
        user = userService.getUser(userName,password);

        req.setAttribute("user", user);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("pages/test.jsp");
        requestDispatcher.forward(req, resp);
    }
}
