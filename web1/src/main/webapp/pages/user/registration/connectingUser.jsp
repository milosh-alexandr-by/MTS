<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 09.02.2016
  Time: 1:03
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
			Регистрация
		</span>
		<span class="registration">
            ${loginCookie}
		</span>
    </header>
    <div class="clear"></div>
    <div id="main">
        <div class="tariffs">

            <br/><hr/><br/>

            <p>Выберите тариф:<p/><br/>
            <form name="selectTariff" method="POST" action="/Controller">
                <input type="hidden" name="command" value="connectingTariff"/>
                <input type="hidden" name="goPage" value="connectingService"/>
                <table class="usertable">
                    <tr>
                        <th>Select</th>
                        <th>Title</th>
                        <th>Cost Per Minute</th>
                        <th>Abonent Cost Per Month</th>
                    </tr>
                    <c:forEach var="t" items="${requestScope.tariffs}">
                        <tr>
                            <td><input type="radio" name="tariff" value="${t.getTariffId()}"></td>
                            <td><c:out value="${t.getTariffName()}" />
                            <td><c:out value="${t.getCostPerMinute()}" />
                            <td><c:out value="${t.getAbonentCost()}" />
                        <tr />
                    </c:forEach>
                </table><br/>
                <p><input type="submit" value="Отправить">
                    <input type="reset" value="Очистить"></p>
            </form>

            <br/><hr/><br/>

            <br/><hr/><br/>
            Логин юзера из куки: ${loginCookie}
            <br/><br/>

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
