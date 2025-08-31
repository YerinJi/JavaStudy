<%--
  Created by IntelliJ IDEA.
  User: yerin
  Date: 2025-08-31
  Time: 오후 11:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Title</title>
  </head>
  <body>
    <h2>로그인폼</h2>
  <form action="<%=request.getContextPath()%>/login.doo?cmd=login" method="post">
    <input type="text" name="id" placeholder="ID"><br>
    <input type="password" name="password" placeholder="Password"><br>
    <button type="submit">submit</button>
  </form>
  </body>
</html>
