<%--
  Created by IntelliJ IDEA.
  User: yerin
  Date: 2025-08-27
  Time: 오후 2:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Result2</h1>
<%
    out.print("request="+request.getAttribute("data")+"<br>");
    out.print("session="+session.getAttribute("data")+"<br>");
    out.print("application="+application.getAttribute("data")+"<br>");
%>
</body>
</html>
