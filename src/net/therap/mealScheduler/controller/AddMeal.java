package net.therap.mealScheduler.controller;

import net.therap.mealScheduler.domain.Meal;
import net.therap.mealScheduler.domain.User;
import net.therap.mealScheduler.service.MealServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created with IntelliJ IDEA.
 * User: rifatul.islam
 * Date: 5/21/14
 * Time: 10:40 AM
 * To change this template use File | Settings | File Templates.
 */

@WebServlet(name = "AddMeal", urlPatterns = "/addmeal")
public class AddMeal extends javax.servlet.http.HttpServlet {
    private Meal meal;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        setMeal(req);
        new MealServiceImpl().addMeal(meal);
        req.setAttribute("mealAddedSuccess", true);
        resp.sendRedirect(req.getContextPath() + "/home?mealAddedSuccess=" + true);
    }

    private void setMeal(HttpServletRequest req) {
        meal = new Meal();
        String time = req.getParameter("time");
        Timestamp timestamp = getTimeStampFromString(time);

        meal.setDescription(req.getParameter("meal"));
        meal.setUserId(getUserId(req));
        meal.setMealType(req.getParameter("mealType"));
        meal.setMealTimeStamp(timestamp);
    }

    private Timestamp getTimeStampFromString(String time) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-dd-MM HH:mm:ss");
        Timestamp timestamp = null;
        try {
            java.util.Date parsedDate = simpleDateFormat.parse(time);
            timestamp = new Timestamp(parsedDate.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return timestamp;
    }

    private Integer getUserId(HttpServletRequest req) {
        User user = (User) req.getSession().getAttribute("user");
        return user.getUserId();
    }
}
