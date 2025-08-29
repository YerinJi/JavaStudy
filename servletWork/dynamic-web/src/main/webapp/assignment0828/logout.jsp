<%--
  Created by IntelliJ IDEA.
  User: yerin
  Date: 2025-08-28
  Time: 오후 9:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<%
  session.invalidate();
  response.sendRedirect("/assignment0828/login.jsp");
%>
<body>

</body>
</html>
