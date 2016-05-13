<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 11.02.2016
  Time: 0:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<%@ page import="java.util.List"%>
<%@ page import="by.it.academy.pojos.User"%>
<%@ page import="by.it.academy.daoImpl.UserDaoImpl" %>
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
                        <form name="goNumberPageForm" method="POST" action="/Controller">
                            <input type="hidden" name="command" value="goNumberPage"/>
                            <input type="submit" value="НОМЕРА">
                        </form>
                    </td>
                    <td>
                        АБОНЕНТЫ
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

            <p><b>Список абонентов:</b></p><br/>
            <table class="usertable">
                <tr>
                    <td>
                        <form name="goTariffPageForm" method="POST" action="/Controller">
                            <input type="hidden" name="command" value="sortAbonent"/>
                            <input type="hidden" name="operation" value="id"/>
                            <input type="hidden" name="sortParam" value="${sortParam}"/>
                            <input type="submit" value="Сортировать">
                        </form>
                    </td>
                    <td>
                        <form name="goTariffPageForm" method="POST" action="/Controller">
                            <input type="hidden" name="command" value="sortAbonent"/>
                            <input type="hidden" name="operation" value="login"/>
                            <input type="hidden" name="sortParam" value="${sortParam}"/>
                            <input type="submit" value="Сортировать">
                        </form>
                    </td>
                    <td>
                        <form name="goTariffPageForm" method="POST" action="/Controller">
                            <input type="hidden" name="command" value="sortAbonent"/>
                            <input type="hidden" name="operation" value="password"/>
                            <input type="hidden" name="sortParam" value="${sortParam}"/>
                            <input type="submit" value="Сортировать">
                        </form>
                    </td>
                    <td>
                        <form name="goTariffPageForm" method="POST" action="/Controller">
                            <input type="hidden" name="command" value="sortAbonent"/>
                            <input type="hidden" name="operation" value="tariff"/>
                            <input type="hidden" name="sortParam" value="${sortParam}"/>
                            <input type="submit" value="Сортировать">
                        </form>
                    </td>
                    <td>
                        <form name="goTariffPageForm" method="POST" action="/Controller">
                            <input type="hidden" name="command" value="sortAbonent"/>
                            <input type="hidden" name="operation" value="account"/>
                            <input type="hidden" name="sortParam" value="big"/>
                            <input type="submit" value="Сортировать">
                        </form>
                    </td>
                </tr>
                <tr>
                    <th>Id</th>
                    <th>Login</th>
                    <th>Password</th>
                    <th>Tariff</th>
                    <th>Account</th>
                </tr>
                <c:forEach var="u" items="${requestScope.users}">
                    <tr>
                        <td><c:out value="${u.getId()}" />
                        <td><c:out value="${u.getLogin()}" />
                        <td><c:out value="${u.getPassword()}" />
                        <td><c:out value="${u.getTariff().getTariffName()}" />
                        <td><c:out value="${u.getAccount()}" />
                    <tr />
                </c:forEach>
            </table>
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
