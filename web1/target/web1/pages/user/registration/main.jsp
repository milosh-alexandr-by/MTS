<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 08.02.2016
  Time: 16:00
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
            ${user.getLogin()}
<!--			<a href="Controller?command=logout" title="Вход">Выйти</a>  -->
		</span>
		<span class="registration">
            ${loginCookie}
		</span>
    </header>
    <div class="clear"></div>
    <div id="main">
        <div class="tariffs">

            <br/><hr/><br/>

            Пользователь ${user.getLogin()}, добро пожаловать!<br/>
            Спасибо, что воспользовались услугами нашей компании.

            <br/><br/><hr/><br/>

            <form name="goConnectingUserPageForm" method="POST" action="/Controller">
                <input type="hidden" name="command" value="goConnectingUserPage"/>
                <input type="submit" value="ПОДКЛЮЧИТЬСЯ">
            </form>

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
