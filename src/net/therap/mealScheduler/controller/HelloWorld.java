package net.therap.mealScheduler.controller;

import javax.servlet.annotation.WebServlet;
import java.io.IOException;

/**
 * Created by shovon on 5/20/14.
 */

@WebServlet(name = "HelloWorld",urlPatterns = "/hello")
public class HelloWorld extends javax.servlet.http.HttpServlet {

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        request.getRequestDispatcher("pages/test.jsp").forward(request, response);
    }
}
