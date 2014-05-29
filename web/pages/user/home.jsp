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
</head>
<body>
<div class="basic-grey">
    <h1>Welcome to Therap Meal Scheduler
        <span>&nbsp;</span>
        <c:choose>
            <c:when test="${sessionScope.isAdmin}">
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
        <c:when test="${sessionScope.isAdmin}">
            <jsp:include page="meal_form.jsp"/>
        </c:when>
    </c:choose>
    <hr>
    <jsp:include page="meal_table.jsp"/>
</div>
</body>
</html>
