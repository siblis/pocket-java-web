<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: anna
  Date: 17.10.2018
  Time: 20:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>PocketMSG</title>

</head>
<body>
<%
    out.println("<h3> Welcome, " + request.getSession().getAttribute("name") + "!</h3>");
%>

<div>
    <style>
        <%@include file="styles/w3.css"%>
    </style>

    <div id="wrapper">

        <div id="chatbox"></div>

        <div id="usermsg">
            <form method="post">
                <p><textarea name="text" placeholder="Print your message here" id="msg" cols="50" rows="5"></textarea></p>
                <p><input id="submit" type="submit" value="SEND"></p>
            </form>
        </div>
    </div>

    <div id="userList">
        <form>
            <label>
                <input type="text" name="email"><br />
                <button type="submit">Add new user</button>
            </label>
        </form>

    </div>
</div>

</body>
</html>
