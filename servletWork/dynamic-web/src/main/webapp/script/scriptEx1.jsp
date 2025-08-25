<%--
  Created by IntelliJ IDEA.
  User: yerin
  Date: 2025-08-25
  Time: 오후 1:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%-- Script =  Declation + Scriptlet + Expression --%>
<%-- Declaration --%>
<%!
  int count = 0;
//  public void sum(int data){
//    //메소드 생성
//  }
%>

<%-- Scriptlet --%>
<%
  int num = 0;
  count++;
  num++;
 // public void sum(int data){
  // java는 메소드 안에 메소드 생성불가
 // }
%>

<%-- Expression --%>
COUNT= <%=count%><br>
NUM=<%=num%><br>
</body>
</html>
