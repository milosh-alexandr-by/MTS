<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 08.02.2016
  Time: 14:51
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
    <link href="/../css/main.css" rel="stylesheet" type="text/css">
    <link rel="shortcut icon" type="image/x-icon" href="/../images/ico/MTS_ico.ico">
    <title>First page</title>
    <script type='text/javascript'>
        function validate(){
            //Считаем значения из полей name и email в переменные x и y
            var x=document.forms['form']['name'].value;
            var y=document.forms['form']['email'].value;
            //Если поле name пустое выведем сообщение и предотвратим отправку формы
            if (x.length==0){
                document.getElementById('namef').innerHTML='*данное поле обязательно для заполнения';
                return false;
            }
            //Если поле email пустое выведем сообщение и предотвратим отправку формы
            if (y.length==0){
                document.getElementById('emailf').innerHTML='*данное поле обязательно для заполнения';
                return false;
            }
            //Проверим содержит ли значение введенное в поле email символы @ и .
            at=y.indexOf("@");
            dot=y.indexOf(".");
            //Если поле не содержит эти символы знач email введен не верно
            if (at<1 || dot <1){
                document.getElementById('emailf').innerHTML='*email введен не верно';
                return false;
            }
        }
    </script>
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
		<span class="registration">
			Регистрация
		</span>
    </header>
    <div class="clear"></div>
    <div id="main">
        <div class="tariffs">

            РЕГИСТРАЦИЯ

            <br/><br/><hr/><br/>

            <form name="form" method="POST" action="/Controller" onsubmit="return validate()">
                <input type="hidden" name="command" value="registration"/>
                Enter Login: <input type="text" name="login" placeholder="login" /><span style='color:red' id='namef'></span><br /><br/><br/>
                Enter Password: <input type="password" name="password" placeholder="password" /><span style='color:red' id='emailf'></span><br /><br/><br/>
                <input type="submit" value="Log in">
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
