package net.therap.mealScheduler.service;

import net.therap.mealScheduler.dao.MealDao;
import net.therap.mealScheduler.dao.MealDaoImpl;
import net.therap.mealScheduler.domain.Meal;

import java.sql.Date;
import java.sql.Timestamp;
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
//        if (meal.getMealType().equals(MealType.BREAKFAST)) {
//            Meal todayMeal = mealDao.getTodayBreakFast(getToday(meal.getMealTimeStamp()));
//            if (todayMeal != null) {
//
//            }
//        }
    }

    @Override
    public List<Meal> getAllMealOfWeek() {
        return mealDao.getAllMealOfWeek();
    }

    private Date getToday(Timestamp timestamp) {
        Date date = new Date(timestamp.getTime());
        return date;
    }
}
