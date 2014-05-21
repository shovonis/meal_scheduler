<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Home</title>
    <script>
        $(document).ready(function () {
            $(".tableForm").prop('disabled', true);
            $("#edit").click(function () {
                $(".tableForm").prop('disabled', false);
            });
            $("input[type='datetime']").datepicker({
                minDate: 0,
                dateFormat: 'yy-dd-mm',
                onSelect: function (datetext) {
                    var d = new Date();
                    datetext = datetext + " " + d.getHours() + ": " + d.getMinutes() + ": " + d.getSeconds();
                    $("input[type='datetime']").val(datetext);
                }
            });

        });
        $(function () {
            $('#date').datepicker({
                minDate: 0,
                dateFormat: 'yy-dd-mm',
                onSelect: function (datetext) {
                    var d = new Date();
                    datetext = datetext + " " + d.getHours() + ": " + d.getMinutes() + ": " + d.getSeconds();
                    $('#date').val(datetext);
                }
            });
        });



    </script>
<body>

<div class="basic-grey">
    <p>
        <c:if test="${requestScope.mealAddedSucess eq true}">
            Meal Added Successfully.
        </c:if>
    </p>

    <h1>Welcome to Therap Meal Scheduler
        <span>&nbsp;</span>
        <c:choose>
            <c:when test="${sessionScope.isAdmin eq 1}">
                <span> Admin:<c:out value="${sessionScope.user.userName}"/></span>
            </c:when>
            <c:otherwise>
                <span> User:<c:out value="${sessionScope.user.userName}"/></span>
            </c:otherwise>
        </c:choose>
        <span><a href="logout" class="link">Logout</a></span>
        <span>Today is : <c:out value="${requestScope.today}"/></span>
    </h1>

    <c:choose>
        <c:when test="${sessionScope.isAdmin eq 1}">
            <jsp:include page="admin_form.jsp"/>
        </c:when>
    </c:choose>
    <table border="1px">
        <th>Date</th>
        <th>Day</th>
        <th>Meal Type</th>
        <th>Meal Description</th>
        <th>Edit</th>
        <c:if test="${requestScope.mealList != null}">
            <form action="#" method="post">
                <c:forEach var="meal" items="${requestScope.mealList}">
                    <tr>
                        <td><input class="tableForm" name="mealTimeStamp" type="datetime"
                                   value="<c:out value="${meal.mealTimeStamp}"/>"/></td>
                        <td><c:out value="${meal.mealServedDay}"/></td>
                        <td><input class="tableForm" name="mealType" value="<c:out value="${meal.mealType}"/>"/></td>
                        <td><input class="tableForm" name="description" value="<c:out value="${meal.description}"/>"/>
                        </td>
                        <td><img src="<c:url value="/images/edit.jpg"/>" height="20px" width="20px" id="edit"></td>
                    </tr>
                </c:forEach>
            </form>
        </c:if>
    </table>
</div>
</body>
</html>
