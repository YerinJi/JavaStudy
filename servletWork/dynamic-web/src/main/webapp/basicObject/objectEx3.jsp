<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: yerin
  Date: 2025-08-27
  Time: 오후 1:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Session객체 </h1>
<%
    // request, response, pageContext (허락없이 잠깐 들어와있는 객체)
    // session 일정 시간동안 빌린상태
    // application(ServletContext) 건물전체

%>
session.getServletContext()=는 웹 어플리케이션의 전체범위에 접근할때 사용하는 메소드
<%=
    session.getServletContext()
%><br>
session.getClass()=class org.apache.catalina.session.StandardSessionFacade
<%=
    session.getClass()
%>
<%
    HttpSession session1; //session의 기본 자료형은 interface입니다.
    session.setAttribute("msg","hello");
    session.setAttribute("message","hi");
    session.getAttribute("msg");

%>

session.getAttribute("msg")<%=session.getAttribute("msg")%><br>
session.getMaxInactiveInterval()<%=session.getMaxInactiveInterval()%><br>
session.getCreationTime()<%=new Date(session.getCreationTime())%><br>
session.getLastAccessedTime()<%=new Date(session.getLastAccessedTime())%><br>
</body>
</html>
