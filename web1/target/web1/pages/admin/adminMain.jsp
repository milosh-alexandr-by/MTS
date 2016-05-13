<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 08.02.2016
  Time: 20:47
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
${loginCookie}
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
            ${user.getLogin()}
		</span>
    </header>
    <div class="clear"></div>
    <div id="main">
        <div class="tariffs">
            <form name="goTariffPageForm" method="POST" action="/Controller">
                <input type="hidden" name="command" value="goTariffPage"/>
                <input type="submit" value="ТАРИФЫ">
            </form><br/>

            <form name="goServicePageForm" method="POST" action="/Controller">
                <input type="hidden" name="command" value="goServicePage"/>
                <input type="submit" value="УСЛУГИ">
            </form><br/>

            <form name="goNumberPageForm" method="POST" action="/Controller">
                <input type="hidden" name="command" value="goNumberPage"/>
                <input type="submit" value="НОМЕРА">
            </form><br/>

            <form name="goAbonentPageForm" method="POST" action="/Controller">
                <input type="hidden" name="command" value="goAbonentPage"/>
                <input type="hidden" name="sortParam" value="small"/>
                <input type="submit" value="АБОНЕНТЫ">
            </form><br/>

            <form name="goAbonentPageForm" method="POST" action="/Controller">
                <input type="hidden" name="command" value="goNewsPage"/>
                <input type="hidden" name="inverse" value="no"/>
                <input type="hidden" name="changePage" value="0"/>
                <input type="submit" value="НОВОСТИ">
            </form><br/>
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
