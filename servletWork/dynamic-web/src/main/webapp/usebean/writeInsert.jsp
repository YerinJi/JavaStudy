<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  request.setCharacterEncoding("UTF-8");
%>
<jsp:useBean id="bean" class="com.multi.model.vo.WriteVO" scope="application"/>
<jsp:setProperty name="bean" property="*"/>
<html>
<head>
    <title>Title</title>
</head>
<body>
  <a href="list.jsp"><%=bean%></a>

</body>
</html>
