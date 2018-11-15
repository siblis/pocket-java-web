<%--
#parse
*/--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Add new user</title>
</head>
<body>

<div>
    <%
        if(request.getAttribute("userName") != null){
            out.println("<p> User " + request.getAttribute("userName") + " added!</p>");
        }
    %>
</div>
<div align="center">
    <div>
        <h2>ADD USER</h2>
    </div>
    <%--
    //TODO: Добавил проверку на валидность данных. Но возможно этот пункт можно улучшить. Хапёрский Павел.
    --%>
    <form action="index" method="post">
        <p>
            <input id="name" type="text" size="40" charset="UTF-8" placeholder="Имя" title="Введите имя." name="name" required pattern="[0-9a-zA-Zа-яА-ЯёЁ.,\- ]+">
        </p>
        <p>
            <input type="email" size="40" charset="UTF-8" name="email" placeholder="Введите E-mail" pattern="([A-z0-9_.-]{1,})@([A-z0-9_.-]{1,}).([A-z]{2,8})" title="Введите электронный адрес(email)" required/>
        </p>
        <p>
            <input type="password" size="40" charset="UTF-8" placeholder="Введите пароль" title="Введите пароль." name = "pass" required>
        </p>
        <p>
            <input id="pass" charset="UTF-8" type="password" size="40" placeholder="Введите пароль повторно" title="Введите пароль повторно." name = "pass" required>
        </p>

        <p>
            <label>
                <button type="submit">Подтверждение</button>
                <button onclick="location.href='/'">Отмена</button>
            </label>
        </p>
    </form>

</div>

<div align="center">
</div>

</body>
</html>
