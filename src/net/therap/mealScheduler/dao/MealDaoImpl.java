package net.therap.mealScheduler.dao;

import net.therap.mealScheduler.domain.Meal;
import net.therap.mealScheduler.util.DatabaseTemplate;
import net.therap.mealScheduler.util.ObjectRowMapper;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: rifatul.islam
 * Date: 5/21/14
 * Time: 10:52 AM
 * To change this template use File | Settings | File Templates.
 */
public class MealDaoImpl implements MealDao {
    @Override
    public void addMeal(Meal meal) {
        String insertQuery = "INSERT INTO `mealdb`.`meal` (`meal_id`, `user_id`, `meal_type`, `date_time`, `description`)" +
                " VALUES (NULL, ?, ?, ?, ?);";

        Integer userId = meal.getUserId();
        String mealType = meal.getMealType();
        Timestamp mealDate = meal.getMealTimeStamp();
        String description = meal.getDescription();
        DatabaseTemplate.executeInsertQuery(insertQuery, userId, mealType, mealDate, description);
    }

    @Override
    public Meal getTodayMeal(Date today) {
        return null;
    }

    @Override
    public Meal getTodayBreakFast(Date today) {
        String query = "SELECT * FROM meal WHERE meal_type = ? AND date_time = ?";
        List<Meal> mealList = DatabaseTemplate.queryForObject(new ObjectRowMapper<Meal>() {
            @Override
            public Meal mapRowToObject(ResultSet resultSet) throws SQLException {
                return setMeal(resultSet);
            }
        }, query, MealType.BREAKFAST, today);
        if (mealList.size() > 0) {
            return mealList.get(0);
        }
        return null;
    }

    @Override
    public Meal getTodayLunch(Date today) {
        return null;
    }

    @Override
    public List<Meal> getAllMealOfWeek() {
        String query = "SELECT * FROM meal WHERE YEARWEEK(date_time)=YEARWEEK(NOW())";
        List<Meal> mealList = DatabaseTemplate.queryForObject(new ObjectRowMapper<Meal>() {
            @Override
            public Meal mapRowToObject(ResultSet resultSet) throws SQLException {
                return setMeal(resultSet);
            }
        }, query);
        return mealList;
    }

    private Meal setMeal(ResultSet resultSet) throws SQLException {
        Meal meal = new Meal();
        meal.setMealId(resultSet.getInt("meal_id"));
        meal.setUserId(resultSet.getInt("user_id"));
        meal.setMealType(resultSet.getString("meal_type"));
        meal.setMealTimeStamp(resultSet.getTimestamp("date_time"));
        meal.setMealServedDay(getDayOfWeek(meal.getMealTimeStamp()));
        meal.setDescription(resultSet.getString("description"));
        return meal;
    }

    private String getDayOfWeek(Timestamp timestamp) {
        return new SimpleDateFormat("EEEE").format(timestamp.getTime());
    }
}
