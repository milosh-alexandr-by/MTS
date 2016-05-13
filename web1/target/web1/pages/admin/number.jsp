<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 09.02.2016
  Time: 0:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<%@ page import="java.util.List"%>
<%@ page import="by.it.academy.pojos.Number"%>
<%@ page import="by.it.academy.daoImpl.NumberDaoImpl" %>
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
            <table>
                <tr>
                    <td>
                        <form name="goTariffPageForm" method="POST" action="/Controller">
                            <input type="hidden" name="command" value="goTariffPage"/>
                            <input type="submit" value="ТАРИФЫ">
                        </form>
                    </td>
                    <td>
                        <form name="goServicePageForm" method="POST" action="/Controller">
                            <input type="hidden" name="command" value="goServicePage"/>
                            <input type="submit" value="УСЛУГИ">
                        </form>
                    </td>
                    <td>
                        НОМЕРА
                    </td>
                    <td>
                        <form name="goAbonentPageForm" method="POST" action="/Controller">
                            <input type="hidden" name="command" value="goAbonentPage"/>
                            <input type="submit" value="АБОНЕНТЫ">
                        </form>
                    </td>
                    <td>
                        <form name="goAbonentPageForm" method="POST" action="/Controller">
                            <input type="hidden" name="command" value="goNewsPage"/>
                            <input type="hidden" name="inverse" value="no"/>
                            <input type="hidden" name="changePage" value="0"/>
                            <input type="submit" value="НОВОСТИ">
                        </form>
                    </td>
                </tr>
            </table>

            <br/><hr><br/>

            <p><b>Список номеров:</b></p><br/>
            <table class="usertable">
                <tr>
                    <th>Id</th>
                    <th>Number</th>
                    <th>Beautiful</th>
                    <th>Cost</th>
                    <th>Used</th>
                    <th>User_ID</th>
                </tr>
                <c:forEach var="n" items="${requestScope.numbers}">
                    <tr>
                        <td><c:out value="${n.getNumberId()}" /></td>
                        <td><c:out value="${n.getNumber()}" /></td>
                        <td><c:out value="${n.isBeautiful()}" /></td>
                        <td><c:out value="${n.getCost()}" /></td>
                        <td><c:out value="${n.isUsed()}" /></td>
                        <td><c:out value="${n.getUser()}" /></td>
                    <tr />
                </c:forEach>
            </table>

            <br/><hr><br/>

            <p><b>Добавить номер:</b></p><br/>
            <form name="addNumberForm" method="POST" action="/Controller">
                <input type="hidden" name="command" value="addNumber"/>
                Phone Number: <input type="text" name="number" value=""/><br/><br/>
                Beautiful: <input type="text" name="beautiful" value=""/><br/><br/>
                Cost of Beautiful Number: <input type="text" name="cost" value=""/><br/><br/>
                Used: <input type="text" name="used" value=""/><br/><br/>
                <input type="submit" value="Add Number">
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
