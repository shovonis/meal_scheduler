<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title></title>
</head>
<body>

<div class="basic-grey">
    <h1>Welcome Therap Meal Scheduler
        <span>&nbsp;</span>
        <c:choose>
            <c:when test="${sessionScope.isAdmin eq 1}">
                <span> Admin:<c:out value="${sessionScope.user.userName}"/></span>
            </c:when>
            <c:otherwise>
                <span>   User  <c:out value="${sessionScope.user.userName}"/></span>
            </c:otherwise>
        </c:choose>

        <span><a href="#" class="link">Logout</a></span>

    </h1>
</div>

</body>
</html>
