<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Login</title>
</head>
<body>
<form action="login" method="post" class="basic-grey">
    <h1>Therap Meal Scheduler
        <span>Please Login</span>
    </h1>
    <label>
        <span>User Name :</span>
        <input id="name" type="text" name="userName" placeholder="user name"/>
    </label>

    <label>
        <span>Password :</span>
        <input id="email" type="password" name="password" placeholder="password"/>
    </label>
    <label>
        <span>&nbsp;</span>
        <input type="submit" class="button" value="Login"/>
    </label>
</form>
</body>
</html>
