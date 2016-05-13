<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 18.04.2016
  Time: 19:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false"%>
<%@ page import="by.it.academy.support.CookiesController" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="keywords" content="test, site, website" />
    <meta name="description" content="Это пробный сайт моего проекта" />
    <link href="/../../css/main.css" rel="stylesheet" type="text/css">
    <link rel="shortcut icon" type="image/x-icon" href="/../../images/ico/MTS_ico.ico">
    <title>First page</title>
</head>
<body>
<%  CookiesController cookiesController = new CookiesController();
    cookiesController.getCookies(request, response);
%>
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
			<a href="Controller?command=logout" title="Вход">Выйти</a>
		</span>
		<span class="registration">
            ${loginCookie}
		</span>
    </header>
    <div class="clear"></div>
    <div id="main">
        <div class="tariffs">

            <br/><hr/><br/>

            <p>Выберите услугу (услуги):<p/><br/><br/>
            <table class="usertable">
                <tr>
                    <th>Title</th>
                    <th>Subscribe</th>
                    <th>Cost</th>
                    <th>Подключить/Отключить</th>
                    <th>Состояние</th>
                </tr>
                <c:set var="numberOfServices" value="0"/>
                <c:forEach var="s" items="${requestScope.servicesForUser}">
                    <c:set var="numberOfServices" value="${numberOfServices+1}"/>
                    <tr>
                        <td><c:out value="${s.getServiceName()}" /></td>
                        <td><c:out value="${s.getSubscribe()}" /></td>
                        <td><c:out value="${s.getCost()}" /></td>
                        <td><c:choose>
                            <c:when test="${s.isUserUsed()}">
                                <form name="goTariffMainPageForm" method="POST" action="/Controller">
                                    <input type="hidden" name="command" value="disConnectingService"/>
                                    <input type="hidden" name="goPage" value="changeUserServices"/>
                                    <input type="hidden" name="numberOfService" value="${s.getServiceId()}"/>
                                    <input type="submit" value="Отключить услугу"></form>
                            </c:when>
                            <c:otherwise>
                                <form name="goTariffMainPageForm" method="POST" action="/Controller">
                                    <input type="hidden" name="command" value="connectingService"/>
                                    <input type="hidden" name="goPage" value="changeUserServices"/>
                                    <input type="hidden" name="numberOfService" value="${s.getServiceId()}"/>
                                    <input type="submit" value="Подключить услугу"></form>
                            </c:otherwise>
                        </c:choose>
                        </td>
                        <td><c:choose>
                            <c:when test="${s.isUserUsed()}">
                                Подключена.
                            </c:when>
                            <c:otherwise>
                                Не подключена.
                            </c:otherwise>
                        </c:choose>
                        </td>
                    <tr />
                </c:forEach>
                <input type="hidden" name="number" value="${numberOfServices}"/>
            </table>

            <br/><hr/><br/>

            <form name="goTariffMainPageForm" method="POST" action="/Controller">
                <input type="hidden" name="command" value="goUserMain"/>
                <input type="hidden" name="goPage" value="changeUserService"/>
                <input type="submit" value="Вернуться">
            </form>

            <br/><hr/><br/>

        </div>
    </div>
</div>
<footer>
	<span class="copyright">
			© 2016 COOO «Образовательный центр Парка высоких технологий»
	</span>
	<span class="author">
			Разработка сайта - <a href="author.html" title="Автор">Милош Александр</a>
	</span>
</footer>
</body>
</html>
