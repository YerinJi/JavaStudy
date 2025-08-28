
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
  String id = request.getParameter("id");
  String checker = request.getParameter("checker");
  Cookie cookie = new Cookie("id",id);
  cookie.setMaxAge(checker!= null && checker.equals("on")?60:0);
  response.addCookie(cookie);
%>

</body>
</html>
