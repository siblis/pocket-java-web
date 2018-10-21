<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: anna
  Date: 15.10.2018
  Time: 21:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Users list</title>
</head>
<body>
   <div>
    <h2>There should be list of users</h2>
<%
    List<String> names = (List<String>) request.getAttribute("userNames");
    if(names != null && !names.isEmpty()){
        out.println("<ui>");
        for( String s: names){
            out.println("<li>" + s + "</li>");
        }
        out.println("</ui>");
    } else out.println("<p> There are no users yet!</p>");

%>
   </div>
    <div>
        <button onclick="location.href='/'">Back to main</button>
    </div>
</body>
</html>
