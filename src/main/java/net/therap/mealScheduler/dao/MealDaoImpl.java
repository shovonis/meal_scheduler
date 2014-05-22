package net.therap.mealScheduler.dao;

import net.therap.mealScheduler.domain.Meal;
import net.therap.mealScheduler.util.DatabaseTemplate;
import net.therap.mealScheduler.util.DateTimeManager;
import net.therap.mealScheduler.util.ObjectRowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
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
        DatabaseTemplate.executeUpdate(insertQuery, userId, mealType, mealDate, description);
    }

    @Override
    public List<Meal> getAllMealOfWeek() {
        String query = "SELECT * FROM meal WHERE YEARWEEK(date_time)=YEARWEEK(NOW()) ORDER BY date_time DESC LIMIT 5";

        List<Meal> mealList = DatabaseTemplate.queryForObject(new ObjectRowMapper<Meal>() {
            @Override
            public Meal mapRowToObject(ResultSet resultSet) throws SQLException {
                return setMeal(resultSet);
            }
        }, query);

        return mealList;
    }

    @Override
    public void updateMeal(Meal meal) {
        String updateQuery = "UPDATE meal SET meal_type = ? , description = ?" +
                " WHERE meal_id = ?";

        DatabaseTemplate.executeUpdate(updateQuery, meal.getMealType(),
                meal.getDescription(), meal.getMealId());
    }

    @Override
    public void deleteMeal(Integer mealId) {
        String deleteQuery = "DELETE FROM meal WHERE meal_id = ?";
        DatabaseTemplate.executeUpdate(deleteQuery, mealId);
    }

    private Meal setMeal(ResultSet resultSet) throws SQLException {
        Meal meal = new Meal();
        meal.setMealId(resultSet.getInt("meal_id"));
        meal.setUserId(resultSet.getInt("user_id"));
        meal.setMealType(resultSet.getString("meal_type"));
        meal.setMealTimeStamp(resultSet.getTimestamp("date_time"));
        meal.setMealServedDay(DateTimeManager.getDayOfWeek(meal.getMealTimeStamp()));
        meal.setDescription(resultSet.getString("description"));
        return meal;
    }
}
