package net.therap.mealScheduler.dao;

import net.therap.mealScheduler.domain.Meal;
import net.therap.mealScheduler.util.date.DateTimeManager;
import net.therap.mealScheduler.util.db.DatabaseTemplate;
import net.therap.mealScheduler.util.db.ObjectRowMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : rifatul.islam
 *         Date: 5/21/14
 *         Time: 10:52 AM
 */
public class MealDaoImpl implements MealDao {
    private static final Logger log = LoggerFactory.getLogger(MealDao.class);

    @Override
    public void addMeal(Meal meal) {
        String insertQuery = "INSERT INTO `mealdb`.`meal` (`meal_id`, `user_id`, `meal_type`, `date_time`, `description`)" +
                " VALUES (NULL, ?, ?, ?, ?);";

        Integer userId = meal.getUserId();
        String mealType = meal.getMealType();
        Timestamp mealDate = meal.getMealTimeStamp();
        String description = meal.getDescription();
        DatabaseTemplate.executeUpdate(insertQuery, userId, mealType, mealDate, description);
        log.debug("Meal inserted");
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

        log.debug("Meal List Returned");
        return mealList;
    }

    @Override
    public void updateMeal(Meal meal) {
        String updateQuery = "UPDATE meal SET meal_type = ? , description = ?" +
                " WHERE meal_id = ?";

        DatabaseTemplate.executeUpdate(updateQuery, meal.getMealType(),
                meal.getDescription(), meal.getMealId());
        log.debug("Meal Updated");

    }

    @Override
    public void deleteMeal(Integer mealId) {
        String deleteQuery = "DELETE FROM meal WHERE meal_id = ?";
        DatabaseTemplate.executeUpdate(deleteQuery, mealId);
        log.debug("Meal Deleted");
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
