<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 08.02.2016
  Time: 18:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="keywords" content="test, site, website" />
    <meta name="description" content="Это пробный сайт моего проекта" />
    <link href="/../css/main.css" rel="stylesheet" type="text/css">
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
			Вход
		</span>
    </header>
    <div class="clear"></div>
    <div id="main">
        <div class="tariffs">

            ВХОД

            <br/><br/><hr/><br/>

            <form name="loginForm" method="POST" action="/Controller">
                <input type="hidden" name="command" value="login"/>
                Enter Login: <input type="text" name="userLogin" value=""/><br/><br/>
                Enter Password: <input type="password" name="password" value=""/><br/><br/>

                ${errorLoginPassMessage}

                ${wrongAction}

                ${nullPage}

                <input type="submit" value="Log up">
            </form>
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
