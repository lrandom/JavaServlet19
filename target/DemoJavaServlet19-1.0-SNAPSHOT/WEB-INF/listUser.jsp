<%@ page import="java.util.ArrayList" %>
<%@ page import="models.User" %><%--
  Created by IntelliJ IDEA.
  User: Lrandom
  Date: 26/05/2021
  Time: 20:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List User</title>
</head>
<body>
<ul>
    <%
        ArrayList<User> users = (ArrayList<User>) request.getAttribute("users");
        for (User user : users) {
            %>
    <li>
        <div>Id - <%=user.id%></div>
        <div>Username - <%=user.userName%></div>
        <div>Fullname - <%=user.fullName%></div>
        <div>Address - <%=user.address%></div>
    </li>

    <%
        }
    %>

</ul>
</body>
</html>
