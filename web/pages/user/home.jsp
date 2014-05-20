<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<c:if test="${sessionScope.user eq null}">
    <c:redirect url="/"/>
</c:if>

<html>
<head>
    <title></title>
</head>
<body>
Login Successful: <br>
User name ${sessionScope.user.userName}
</body>
</html>
