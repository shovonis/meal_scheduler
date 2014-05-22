package net.therap.mealScheduler.domain;


import java.sql.Timestamp;

/**
 * Created with IntelliJ IDEA.
 * User: rifatul.islam
 * Date: 5/21/14
 * Time: 10:42 AM
 * To change this template use File | Settings | File Templates.
 */
public class Meal {
    private Integer mealId;
    private Integer userId;
    private String mealType;
    private String mealServedDay;
    private Timestamp mealTimeStamp;
    private String description;

    public Integer getMealId() {
        return mealId;
    }

    public void setMealId(Integer mealId) {
        this.mealId = mealId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getMealType() {
        return mealType;
    }

    public void setMealType(String mealType) {
        this.mealType = mealType;
    }

    public Timestamp getMealTimeStamp() {
        return mealTimeStamp;
    }

    public void setMealTimeStamp(Timestamp mealTimeStamp) {
        this.mealTimeStamp = mealTimeStamp;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMealServedDay() {
        return mealServedDay;
    }

    public void setMealServedDay(String mealServedDay) {
        this.mealServedDay = mealServedDay;
    }
}
