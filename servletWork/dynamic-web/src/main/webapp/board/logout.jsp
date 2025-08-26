
<%@ page session="true" %>
<%
  session.invalidate();//(username|admin).invalidate(); session을 리셋해주는 기능
  response.sendRedirect("login.jsp");
%>

