package net.therap.mealScheduler.service;

import net.therap.mealScheduler.domain.Meal;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * @author : rifatul.islam
 * Date: 5/21/14
 * Time: 11:00 AM
 */
public interface MealService {
    public void addMeal(Meal meal);

    public List<Meal> getAllMealOfWeek();

    public void updateMeal(Meal meal);

    public void deleteMeal(Integer mealId);

}
