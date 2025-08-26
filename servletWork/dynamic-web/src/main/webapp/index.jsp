<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="true" %>
<!DOCTYPE html>
<html>
<head>
  <title>JSP - Hello World</title>
</head>
<body>
<%--<h1><%= "Hello World!" %></h1>--%>
<br/>
<%--<a href="colorServlet">colorServlet</a>--%>
<%--<a href="testServlet">testServlet</a>--%>
<%
  if (session.getAttribute("user") != null) {
    response.sendRedirect("board/welcome.jsp");
  } else {
    response.sendRedirect("board/login.jsp");
  }
%>


</body>
</html>