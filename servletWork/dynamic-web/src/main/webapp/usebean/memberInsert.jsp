<%--
  Created by IntelliJ IDEA.
  User: yerin
  Date: 2025-08-25
  Time: 오후 3:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%
    String name = request.getParameter("name");
    String email = request.getParameter("email");
    String pwd = request.getParameter("pwd");
    String remember = request.getParameter("remember");
%>
Name : <%=name%> <br>
Email : <%=email%> <br>
Password : <%=pwd%> <br>
Remember : <%=remember%> <br>

</body>
</html>
