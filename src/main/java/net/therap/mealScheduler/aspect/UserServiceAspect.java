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
public class UserServiceAspect {
    private long startTime;
    private long endTime;

    private static final Logger log = LoggerFactory.getLogger(UserServiceAspect.class);

    @Before("execution(* net.therap.mealScheduler.service.UserServiceImpl.getUser(..) )")
    public void beforeGetUser() {
        startTime = System.currentTimeMillis();
    }

    @After("execution(* net.therap.mealScheduler.service.UserServiceImpl.getUser(..) )")
    public void afterGetUser() {
        endTime = System.currentTimeMillis();
        log.info("Time Needed For Executing getUser(): " + getExecutionTime() + " ms");
    }


    @After("execution(* net.therap.mealScheduler.service.UserServiceImpl.getAllUser(..) )")
    public void beforeGetAllUser() {
        startTime = System.currentTimeMillis();
    }

    @Before("execution(* net.therap.mealScheduler.service.UserServiceImpl.getAllUser(..) )")
    public void afterGetAllUser() {
        endTime = System.currentTimeMillis();
        log.info("Time Needed For executing getAllUser() : " + getExecutionTime() + " ms");
    }

    private long getExecutionTime() {
        return endTime - startTime;
    }
}
