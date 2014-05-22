package net.therap.mealScheduler.service;

import net.therap.mealScheduler.dao.MealDao;
import net.therap.mealScheduler.dao.MealDaoImpl;
import net.therap.mealScheduler.domain.Meal;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: rifatul.islam
 * Date: 5/21/14
 * Time: 11:01 AM
 * To change this template use File | Settings | File Templates.
 */
public class MealServiceImpl implements MealService {
    private MealDao mealDao;

    public MealServiceImpl() {
        this.mealDao = new MealDaoImpl();
    }

    @Override
    public void addMeal(Meal meal) {
        mealDao.addMeal(meal);
    }

    @Override
    public List<Meal> getAllMealOfWeek() {
        return mealDao.getAllMealOfWeek();
    }

    @Override
    public void updateMeal(Meal meal) {
        mealDao.updateMeal(meal);
    }

    @Override
    public void deleteMeal(Integer mealId) {
        mealDao.deleteMeal(mealId);
    }
}
