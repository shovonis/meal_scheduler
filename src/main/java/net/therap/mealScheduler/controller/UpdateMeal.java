package net.therap.mealScheduler.controller;


import net.therap.mealScheduler.domain.Meal;
import net.therap.mealScheduler.service.MealService;
import net.therap.mealScheduler.service.MealServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : rifatul.islam
 *         Date: 5/21/14
 *         Time: 4:05 PM
 */

@WebServlet(name = "UpdateMeal", urlPatterns = "/updatemeal")
public class UpdateMeal extends javax.servlet.http.HttpServlet {
    private static final Logger log = LoggerFactory.getLogger(UpdateMeal.class);
    private Meal meal;
    private MealService mealService;

    public UpdateMeal() {
        this.mealService = new MealServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.debug("Parameter", req.getParameter("mealId"));
        createMealFromRequest(req);
        mealService.updateMeal(meal);
        resp.sendRedirect(req.getContextPath() + "/home");
    }

    private void createMealFromRequest(HttpServletRequest req) {
        Integer mealId = Integer.parseInt(req.getParameter("mealId"));
        meal = new Meal();
        meal.setMealId(mealId);
        meal.setMealType(req.getParameter("mealType"));
        meal.setDescription(req.getParameter("description"));
    }
}
