package net.therap.mealScheduler.controller;

import net.therap.mealScheduler.service.MealService;
import net.therap.mealScheduler.service.MealServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * @author : rifatul.islam
 * Date: 5/22/14
 * Time: 11:29 AM
 */


@WebServlet(name = "DeleteMeal", urlPatterns = "/delete")
public class DeleteMeal extends javax.servlet.http.HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer mealId = Integer.parseInt(req.getParameter("mealId"));
        MealService mealService = new MealServiceImpl();
        mealService.deleteMeal(mealId);
        resp.sendRedirect(req.getContextPath() + "/home");
    }
}
