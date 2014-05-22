package net.therap.mealScheduler.dao;

import net.therap.mealScheduler.domain.Meal;

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

    public List<Meal> getAllMealOfWeek();

    public void updateMeal(Meal meal);

    public void deleteMeal(Integer mealId);
}
