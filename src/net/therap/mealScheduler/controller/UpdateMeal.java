package net.therap.mealScheduler.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by shovon on 5/21/14.
 */

@WebServlet(name = "UpdateMeal", urlPatterns = "/updatemeal")
public class UpdateMeal extends javax.servlet.http.HttpServlet {
    private static final Logger log = LoggerFactory.getLogger(UpdateMeal.class);

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
