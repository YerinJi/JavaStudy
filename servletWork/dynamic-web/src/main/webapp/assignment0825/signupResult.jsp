<%@ page import="java.util.Map" %>
<%@ page import="java.util.Enumeration" %>
<%@ page import="java.util.Arrays" %>
<%@ page import="java.lang.reflect.Array" %><%--
  Created by IntelliJ IDEA.
  User: yerin
  Date: 2025-08-25
  Time: 오후 11:28
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
  String pw = request.getParameter("password");
  String gender = request.getParameter("gender");
  String agree = request.getParameter("agree");
%>
<h2>GetParameter (단일값)</h2> <br>
Name: <%=name%> <br>
Email: <%=email%> <br>
Password: <%=pw%> <br>
Gender: <%=gender%> <br>
Agree: <%=agree%> <br>

<%
  String[] hobbies = request.getParameterValues("hobby");
  String[] skills = request.getParameterValues("skills");
%>
<h2>GetParameterValues (다중값)</h2><br>
Hobbies:<%=Arrays.toString(hobbies)%> <br>
Skills: <%=Arrays.toString(skills)%> <br>
<%
  Map<String, String[]> allMap = request.getParameterMap();
%>
<h2>GetParameterMap (전체 Map 순회)</h2><br>
<%
  for(String key: allMap.keySet()){
%>
<%=
  key
%> =
<%=Arrays.toString(allMap.get(key))%>
<%} %>
<br>

<%
  Enumeration<String> enuNames = request.getParameterNames();
%>
<h2>GetParameterNames</h2><br>
<%
  while(enuNames.hasMoreElements()){
    String pname = enuNames.nextElement();
%>
<%= pname %> : <%= Arrays.toString(request.getParameterValues(pname)) %> <br>
<%
  }
%>
</body>
</html>
