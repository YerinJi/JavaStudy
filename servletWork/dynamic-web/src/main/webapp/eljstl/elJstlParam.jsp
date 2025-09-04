<%--
  Created by IntelliJ IDEA.
  User: yerin
  Date: 2025-09-04
  Time: 오후 4:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>ELJSTL-PARAM</h1>
  NO:${param.no} or <%=request.getParameter("no")%><br>
  JOB:${param.job} or <%=request.getParameter("job")%><br>
</body>
</html>
