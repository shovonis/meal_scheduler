<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-type" content="text/html; charset=utf-8"/>
    <title><decorator:title/></title>

    <link rel="stylesheet" type="text/css" href="<c:url value="/css/style.css" />" media="all">
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/jquery-ui-1.10.4.custom.css" />" media="all">

    <script src="<c:url value="/js/jquery-1.10.2.js"/>"></script>
    <script src="<c:url value="/js/jquery-ui-1.10.4.custom.js" />"></script>

    <decorator:head/>
</head>
<body>
<decorator:body/>
</body>
</html>