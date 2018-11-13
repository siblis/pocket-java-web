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
    <title>Pocket Messenger Web</title>
    <!-- BEGIN   Подключение файла style.css  -->
    <link rel="stylesheet" type="text/css" href="views/styles/style.css">
    <!-- END   Подключение файла style.css  -->
</head>
  <body>

  <%--<header>--%>
      <%--&lt;%&ndash;<div align="center">&ndash;%&gt;--%>
        <%--&lt;%&ndash;<h2>Welcome to Pocket Messenger</h2>&ndash;%&gt;--%>
      <%--&lt;%&ndash;</div>&ndash;%&gt;--%>
  <%--</header>--%>

  <div class="login_380_600">
      <div class="restangle_2_1"></div>
      <div class="ellipse_big"></div>
      <div class="pocket_messenger">Pocket Messenger</div>
      <div class="for_geeks_by_geeks">For geeks by geeks</div>
      <div class="ellipse_small"></div>
      <!--BEGIN OF FORM-->
      <form action="index" method="post">
          <input id="mail" type="text" placeholder="E-mail" name="name" required>
          <input id="pass" type="password" placeholder="Пароль" name = "pass" required>
          <input id="log_in" type="submit" value="Войти">
          <div class="forgot_pass"><a href="">Забыли пароль?</a></div> <!-- форма восстановления пароля -->
      </form>
      <!--END OF FORM-->
      <!--BEGIN OF REGISTRATION-->
      <div class="registration">Нет аккаунта?&nbsp;<a href="/add">Регистрация</a></div>
      <!--END OF REGISTRATION-->
  </div>
  </body>
</html>
