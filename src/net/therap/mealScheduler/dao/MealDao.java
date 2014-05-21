package net.therap.mealScheduler.dao;

import net.therap.mealScheduler.domain.Meal;

import java.sql.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: rifatul.islam
 * Date: 5/21/14
 * Time: 10:48 AM
 * To change this template use File | Settings | File Templates.
 */
public interface MealDao {
    public void addMeal(Meal meal);

    public Meal getTodayMeal(Date today);

    public Meal getTodayBreakFast(Date today);

    public Meal getTodayLunch(Date today);

    public List<Meal> getAllMealOfWeek();

}
