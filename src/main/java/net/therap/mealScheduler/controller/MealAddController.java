package net.therap.mealScheduler.controller;

import net.therap.mealScheduler.domain.Meal;
import net.therap.mealScheduler.domain.User;
import net.therap.mealScheduler.service.MealServiceImpl;
import net.therap.mealScheduler.util.date.DateTimeManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Timestamp;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : rifatul.islam
 *         Date: 5/21/14
 *         Time: 10:40 AM
 */

@WebServlet(name = "MealAddController", urlPatterns = "/addmeal")
public class MealAddController extends javax.servlet.http.HttpServlet {
    private static final Logger log = LoggerFactory.getLogger(MealAddController.class);
    private Meal meal;
    private MealServiceImpl mealService;

    public MealAddController() {
        mealService = new MealServiceImpl();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        createMealFromRequest(req);
        mealService.addMeal(meal);
        log.debug("Meal is added");
        resp.sendRedirect(req.getContextPath() + "/home");
    }

    private void createMealFromRequest(HttpServletRequest req) {
        meal = new Meal();
        String time = req.getParameter("time");
        Timestamp timestamp = DateTimeManager.getTimeStampFromString(time);

        meal.setDescription(req.getParameter("meal"));
        meal.setUserId(getUserId(req));
        meal.setMealType(req.getParameter("mealType"));
        meal.setMealTimeStamp(timestamp);
    }

    private Integer getUserId(HttpServletRequest req) {
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        return user.getUserId();
    }
}
