<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 09.02.2016
  Time: 0:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<%@ page import="java.util.List"%>
<%@ page import="by.it.academy.pojos.Tariff"%>
<%@ page import="by.it.academy.daoImpl.TariffDaoImpl" %>
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
			<c:choose>
                <c:when test="${empty loginCookie}">
                    <a href="/pages/main/login.jsp" title="Вход">Вход</a>
                </c:when>
                <c:otherwise>
                    <a href="Controller?command=logout" title="Вход">Выйти</a>
                </c:otherwise>
            </c:choose>
            <!--			<a href="/pages/main/login.jsp" title="Вход">Вход</a>  -->
		</span>


		<span class="registration">
			 <c:choose>
                 <c:when test="${empty loginCookie}">
                     <a href="/pages/main/registration.jsp" title="Регистрация">Регистрация</a>
                 </c:when>
                 <c:otherwise>
                     <a href="Controller?command=goUserMain&goPage=userAlreadyRegistration" title="Вход">${loginCookie}</a>
                 </c:otherwise>
             </c:choose>
<!--			<a href="/pages/main/registration.jsp" title="Регистрация">Регистрация</a>  -->
		</span>


    </header>
    <div class="clear"></div>
    <div id="main">
        <div class="tariffs">
            <table class="tariffsTable">
                <tr>
                    <td>
                        ТАРИФЫ
                    </td>
                    <td>
                        <form name="goServiceMainPageForm" method="POST" action="/Controller">
                            <input type="hidden" name="command" value="goServiceMainPage"/>
                            <input type="submit" value="УСЛУГИ">
                        </form>
                    </td>
                </tr>
            </table>

            <br/><hr/><br/>

            <center><p><b>Список тарифов:</b></p></center><br/><br/>
            <center><table class="usertable">
                <tr>
                    <th>Title</th>
                    <th>Cost Per Minute</th>
                    <th>Abonent Cost Per Month</th>
                </tr>
                <c:forEach var="t" items="${requestScope.tariffs}">
                    <tr>
                        <td><c:out value="${t.getTariffName()}" />
                        <td><c:out value="${t.getCostPerMinute()}" />
                        <td><c:out value="${t.getAbonentCost()}" />
                    <tr />
                </c:forEach>
            </table></center>
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
