<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<table border="1px">
    <th>Date</th>
    <th>Day</th>
    <th>Meal Type</th>
    <th>Meal Description</th>
    <c:if test="${sessionScope.isAdmin}">
        <th>Edit</th>
        <th>Remove</th>
    </c:if>
    <c:if test="${requestScope.mealList != null}">
        <c:forEach var="meal" items="${requestScope.mealList}">
            <tr>
                <form action="updatemeal" method="get">
                    <td><c:out value="${meal.mealTimeStamp}"/></td>
                    <td><c:out value="${meal.mealServedDay}"/></td>
                    <td><input class="tableForm" name="mealType" value="<c:out value="${meal.mealType}"/>"/></td>
                    <td><input class="tableForm" name="description" value="<c:out value="${meal.description}"/>"/>
                    </td>
                    <c:if test="${sessionScope.isAdmin}">
                        <td><img src="<c:url value="/images/edit.jpg"/>" height="20px" width="20px" id="edit"></td>
                        <td><a href="delete?mealId=${meal.mealId}"><img src="<c:url value="/images/delete.png"/>"
                                                                        height="20px" width="20px" id="delete"></a>
                        </td>
                    </c:if>
                    <input name="mealId" hidden="true" type="text" value="<c:out value="${meal.mealId}"/>"/>
                    <input type="submit" hidden="true"/>
                </form>
            </tr>
        </c:forEach>

    </c:if>
</table>
