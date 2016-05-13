<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false"%>
<%@ page import="java.util.List"%>
<!DOCTYPE html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="keywords" content="test, site, website" />
    <meta name="description" content="Это пробный сайт моего проекта" />
    <link href="/css/main.css" rel="stylesheet" type="text/css">
    <link rel="shortcut icon" type="image/x-icon" href="images/ico/MTS_ico.ico">
    <title>First page</title>
    <style type="text/css">
        .buttonNews {
            width: 25px;
            margin-left: 5px;
            margin-right: 5px;
        }
    </style>
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
                        <form name="goTariffMainPageForm" method="POST" action="/Controller">
                            <input type="hidden" name="command" value="goTariffMainPage"/>
                            <input type="submit" value="ТАРИФЫ">
                        </form>
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

            <table class="usertable">
                <c:forEach var="u" items="${requestScope.newsesPaginationInverse}">
                    <tr>
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
                                    <form name="goTariffMainPageForm" method="POST" action="/Controller" >
                                        <input type="hidden" name="command" value="changeNewsPageMain"/>
                                        <input type="hidden" name="changePage" value="${i}"/>
                                        <input type="hidden" name="inverse" value="yes"/>
                                        <input type="submit" value="${i}" class="buttonNews">
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
	<span class="copyright">
			© 2016 COOO «Образовательный центр Парка высоких технологий»
	</span>
	<span class="author">
			Разработка сайта - <a href="author.html" title="Автор">Милош Александр</a>
	</span>
</footer>
</body>
</html>

