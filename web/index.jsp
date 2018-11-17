<%--
  Created by IntelliJ IDEA.
  User: anna
  Date: 13.10.2018
  Time: 22:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>PM_web_login</title>
    <link rel="stylesheet" href="views/styles/style.css">
</head>
<body>
<header class="header"></header>
<main>
    <content class="content">
        <div class="restangle_2_1"></div>
        <div class="restangle_2_2"></div>
        <div class="restangle_2_3">
            <form action = "index" method="post">
                <input id="mail" type="text" placeholder="Имя пользователя" name="name" required>
                <input id="pass" type="password" placeholder="Пароль" name = "pass" required>
                <input id="log_in" type="submit" value="Войти">
                <div class="error_msg"><%if (request.getAttribute("error_msg") != null) {
                    out.println("<p>" + request.getAttribute("error_msg") + "</p>");
                }%></div>
                <div class="forgot_pass"><a href="">Забыли пароль?</a></div>
            </form>
            <div class="registration">Нет аккаунта?&nbsp;&nbsp;&nbsp;<a href="/add">Регистрация</a></div>
        </div>
        <div class="ellipse_big"></div>
        <div class="pocket_messenger"><h1>Pocket Messenger</h1></div>
        <div class="for_geeks_by_geeks"><h2>For geeks by geeks</h2></div>
        <div class="ellipse_small"></div>
    </content>
</main>
<footer class="footer"></footer>
</body>
</html>
