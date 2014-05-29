<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<form action="addmeal" method="post">
    <label>
        <span>Meal Type:</span>
        <select name="mealType">
            <option value="Breakfast">Breakfast</option>
            <option value="Lunch">Lunch</option>
        </select>
    </label>

    <label>
        <span>Meal Date and Time:</span>
        <input id="date" type="text" name="time"/>
    </label>

    <label>
        <span>Meal Details :</span>
        <textarea id="message" name="meal" placeholder="Meal Items"></textarea>
    </label>

    <label>
        <span>&nbsp;</span>
        <input type="submit" class="button" value="Set Meal"/>
    </label>
</form>


