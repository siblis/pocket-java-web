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

    <title>pocket Messenger web</title>
  </head>
  <body>

  <header>
      <div align="center">
        <h2>Welcome to Pocket Messenger</h2>
      </div>
  </header>

  <div align="center">

      <form action="index" method="post">
          <label> Name:
              <input type="text" name="name"><br />
          </label>

          <label> Password:
              <input type="password" name="pass"><br />
          </label>

          <button type="submit">Войти</button>
      </form>

      <div>  <!-- buttons holder -->


          <%--<button onclick="location.href='/list'">Список пользователей</button> <!-- эту кнопку нужно будет убрать, список реализовать в окне мессенджера-->--%>
          <button onclick="location.href='/add'">Зарегистрироваться</button>
      </div>

      <div>

      </div>

  </div>
  </body>
</html>
