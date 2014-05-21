package net.therap.mealScheduler.service;

import net.therap.mealScheduler.domain.Meal;

import java.sql.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: rifatul.islam
 * Date: 5/21/14
 * Time: 11:00 AM
 * To change this template use File | Settings | File Templates.
 */
public interface MealService {
    public void addMeal(Meal meal);

    public List<Meal> getAllMealOfWeek();


}
