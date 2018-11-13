<%@ page import="app.entities.Messages" %>
<%@ page import="app.entities.User" %>
<%@ page import="static app.entities.User.me" %><%--
  Created by IntelliJ IDEA.
  User: anna
  Date: 17.10.2018
  Time: 20:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<fmt:requestEncoding value="UTF-8" />
<html>
<head>
    <title>PocketMSG</title>

</head>
<body>
<div >
    <a href="index" id="logout">logout</a>
</div>
<%
    out.println("<h3> Welcome, " + me.getName() + "</h3>");
%>

<div>
    <style>
        <%@include file="styles/w3.css"%>
    </style>

    <div id="wrapper">

        <div id="chatbox">
            <%
                    for (String s : Messages.text) {
                        if(s != null) out.println(s);
            %>
            <br>
            <%
                    }
            %>
        </div>

        <div id="usermsg">
            <form method="post" action="${pageContext.request.contextPath}/messenger">
                <p><textarea name="msg" placeholder="Print your message here" id="msg" cols="50" rows="5"></textarea></p>
                <p><input name="sendMessage" type="submit" value="SEND"></p>
            </form>
        </div>
    </div>

    <div id="userList">
        <form method="post" action="${pageContext.request.contextPath}/messenger">
            <label>
                <input type="text" name="addUser"><br />
                <button type="submit">Add new user</button>
            </label>
            <br>
            <%
            for (User user : me.contacts) {
                if(user != null) out.println(user.getName());
            %>
            <br>
            <%
                }
            %>

        </form>

    </div>
</div>

</body>
</html>
