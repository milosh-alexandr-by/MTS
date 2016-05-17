<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 17.05.2016
  Time: 8:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Error/Exception Information</title>
    <link rel="shortcut icon" type="image/x-icon" href="images/ico/MTS_ico.ico">
</head>
<body>
<c:choose>
    <c:when test="${(empty requestScope.throwable) && (empty requestScope.statusCode)}">
        <h2>Error information is missing</h2>
        Please return to the: <a href="http://localhost:8080/">Home Page</a>
    </c:when>
    <c:when test="${not empty requestScope.statusCode}">
        The status code : ${requestScope.statusCode}
    </c:when>
    <c:otherwise>
        <h2>Error information</h2>
        Servlet Name : ${requestScope.servletName} </br></br>
        Exception Type : ${requestScope.throwable.getClass().getName()} </br></br>
        The request URI: ${requestScope.requestUri} </br></br>
        The exception message: ${requestScope.throwable.getMessage()}
    </c:otherwise>
</c:choose>

</body>
</html>
