<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 09.02.2016
  Time: 1:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<%@ page import="java.util.List"%>
<%@ page import="by.it.academy.pojos.Service"%>
<%@ page import="by.it.academy.daoImpl.ServiceDaoImpl" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="keywords" content="test, site, website" />
    <meta name="description" content="Это пробный сайт моего проекта" />
    <link href="css/main.css" rel="stylesheet" type="text/css">
    <link rel="shortcut icon" type="image/x-icon" href="/../images/ico/MTS_ico.ico">
    <title>First page</title>
</head>
<body>
<div id="page-wrap">
    <header>
		<span class="logo">
			<a href="/Controller?command=goIndex&changePage=0&inverse=yes" title="На главную" id="logo"><img class="image" src="/images/MTS_logo.jpg" width="140" height="70"/></a>
		</span>
		<span class="search">
			<input type="text" class="field" placeholder="Поиск">
			<input type="submit" value="Найти">
		</span>
		<span class="enter">
			<a href="/pages/main/login.jsp" title="Вход">Вход</a>
		</span>
		<span class="registration">
			<a href="/pages/main/registration.jsp" title="Регистрация">Регистрация</a>
		</span>
    </header>
    <div class="clear"></div>
    <div id="main">
        <div class="tariffs">
            <table class="tariffsTable">
                <tr>
                    <td>
                        <form name="goTariffPageForm" method="POST" action="/Controller">
                            <input type="hidden" name="command" value="goTariffMainPage"/>
                            <input type="submit" value="ТАРИФЫ">
                        </form>
                    </td>
                    <td>
                        <form name="goServicePageForm" method="POST" action="/Controller">
                            <input type="hidden" name="command" value="goServiceMainPage"/>
                            <input type="submit" value="УСЛУГИ">
                        </form>
                    </td>
                    <td>
                        НОВОСТИ И АКЦИИ
                    </td>
                </tr>
            </table>

            <br/><hr><br/>

            <p><b>Новости</b></p><br/>
            <table class="usertable">
                <tr>
                    <th>Id</th>
                    <th>Content</th>
                </tr>
                <c:forEach var="u" items="${requestScope.newsesPagination}">
                    <tr>
                        <td><c:out value="${u.getNewsId()}" />
                        <td><c:out value="${u.getContent()}" />
                    <tr />
                </c:forEach>
            </table>

            <br/><hr><br/>

            <table>
                <tr>
                    <c:forEach var="i" begin="1" end="${infoNewsesPagination.get(1)}">
                        <th>
                            <c:choose>
                                <c:when test="${i==infoNewsesPagination.get(2)}">
                                    <c:out value="${i}"/>
                                </c:when>
                                <c:otherwise>
                                    <form name="goTariffMainPageForm" method="POST" action="/Controller">
                                        <input type="hidden" name="command" value="changeNewsPageMain"/>
                                        <input type="hidden" name="changePage" value="${i}"/>
                                        <input type="submit" value="${i}">
                                    </form>
                                </c:otherwise>
                            </c:choose>
                        </th>
                    </c:forEach>
                </tr>
            </table>
        </div>
    </div>
</div>
<footer>
</body>
</html>
