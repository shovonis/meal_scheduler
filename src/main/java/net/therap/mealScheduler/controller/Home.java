package net.therap.mealScheduler.controller;

import net.therap.mealScheduler.domain.Meal;
import net.therap.mealScheduler.service.MealServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * @author : rifatul.islam
 * Date: 5/20/14
 * Time: 3:52 PM
 */

@WebServlet(name = "Home", urlPatterns = "/home")
public class Home extends javax.servlet.http.HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Meal> mealList = getAllMeal();
        req.setAttribute("mealList", mealList);
        req.setAttribute("today", new Date());
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("pages/user/home.jsp");
        requestDispatcher.forward(req, resp);
    }

    private List<Meal> getAllMeal() {
        return new MealServiceImpl().getAllMealOfWeek();
    }
}
