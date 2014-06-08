package net.therap.mealScheduler.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author  rifatul.islam on 6/5/14.
 */

@Aspect
public class MealServiceAspect {
    private long startTime;
    private long endTime;

    private static final Logger log = LoggerFactory.getLogger(MealServiceAspect.class);

    @Before("execution(* net.therap.mealScheduler.service.MealServiceImpl.addMeal(..) )")
    public void beforeAddMeal() {
        startTime = System.currentTimeMillis();
    }

    @After("execution(* net.therap.mealScheduler.service.MealServiceImpl.addMeal(..) )")
    public void afterAddMeal() {
        endTime = System.currentTimeMillis();
        log.info("Time Needed For Executing addMeal(): " + getExecutionTime() + " ms");
    }

    @Before("execution(* net.therap.mealScheduler.service.MealServiceImpl.getAllMealOfWeek(..) )")
    public void beforeGetAllMealOfWeek() {
        startTime = System.currentTimeMillis();
    }

    @After("execution(* net.therap.mealScheduler.service.MealServiceImpl.getAllMealOfWeek(..) )")
    public void afterGetAllMealOfWeek() {
        endTime = System.currentTimeMillis();
        log.info("Time Needed For Executing getAllMealOfWeek(): " + getExecutionTime() + " ms");
    }


    @Before("execution(* net.therap.mealScheduler.service.MealServiceImpl.deleteMeal(..) )")
    public void beforeDeleteMeal() {
        startTime = System.currentTimeMillis();
    }

    @After("execution(* net.therap.mealScheduler.service.MealServiceImpl.deleteMeal(..) )")
    public void afterDeleteMeal() {
        endTime = System.currentTimeMillis();
        log.info("Time Needed For Executing deleteMeal(): " + getExecutionTime() + " ms");
    }

    @Before("execution(* net.therap.mealScheduler.service.MealServiceImpl.updateMeal(..) )")
    public void beforeUpdateMeal() {
        startTime = System.currentTimeMillis();
    }

    @After("execution(* net.therap.mealScheduler.service.MealServiceImpl.updateMeal(..) )")
    public void afterUpdateMeal() {
        endTime = System.currentTimeMillis();
        log.info("Time Needed For Executing updateMeal: " + getExecutionTime() + " ms");
    }

    private long getExecutionTime() {
        return endTime - startTime;
    }
}
