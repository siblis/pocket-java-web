<%--
  Created by IntelliJ IDEA.
  User: anna
  Date: 15.10.2018
  Time: 21:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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

        <form method="post">
            <label> Name:
                <input type="text" name="name"><br />
            </label>

            <label> Password:
                <input type="password" name="pass"><br />
            </label>

            <label> Password confirmation:
                <input type="password" name="pass"><br />
            </label>

            <label> e-mail:
                <input type="text" name="email"><br />
            </label>

            <button type="submit">Submit</button>
        </form>

    </div>

    <div align="center">
        <button onclick="location.href='/'">Cancel</button>
    </div>

</body>
</html>
