<%--
  Created by IntelliJ IDEA.
  User: yerin
  Date: 2025-08-28
  Time: 오후 1:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<%
    String id = request.getParameter("user_id");
    String passwd = request.getParameter("user_passwd");
    if(id.equals("admin")&& passwd.equals("1234")){
        request.getSession().setAttribute("id", id);
        request.getSession().setMaxInactiveInterval(60);
        response.sendRedirect("sessionlist.jsp");
    }else{
        response.sendRedirect("login.jsp");
    }
%>
<%--<script>--%>
<%--    alert('id pass Check');--%>
<%--    document.location.href='login.jsp';--%>
<%--</script>--%>

<body>

</body>
</html>
