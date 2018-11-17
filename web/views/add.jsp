<%--
Created by Pavel_Khaperskiy
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
    <form method="post">
        <p>
            <label>
                <input type="text" size="40"  placeholder="Имя" title="Введите имя." name="name" required>
            </label>
        </p>
        <p>
            <label>
                <input type="email" size="40" name="email" placeholder="Введите E-mail" pattern="([A-z0-9_.-]{1,})@([A-z0-9_.-]{1,}).([A-z]{2,8})" required/>
            </label>
        </p>
        <p>
            <label>
                <input type="password" size="40"  placeholder="Введите пароль" title="Введите пароль." name = "pass" required>
            </label>
        </p>
        <p>
            <label>
                <input type="password" size="40" placeholder="Введите пароль повторно" title="Введите пароль повторно." name = "pass" required>
            </label>
        </p>
        <p>
            <label>
                <button type="submit">Submit</button>
            </label>
            <label>
                <button onclick="location.href='/'">Отмена</button>
            </label>
        </p>
    </form>
    <p>

    </p>
</div>

<div align="center">
</div>

</body>
</html>
