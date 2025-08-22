<%--
  Created by IntelliJ IDEA.
  User: yerin
  Date: 2025-08-22
  Time: 오후 2:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        .num{text-align:right; font-variant-numeric: tabular-nums;}
    </style>
</head>
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
<body topmargin="50">
<%--scriptlet은 service메소드 영역--%>
<table class="table-striped table-hover table-bordered table-compact">
    <thead>
    <tr>
            <%
                for(int i=2; i<=9; i++){
                    %>
        <td><%=i%>단</td>
            <%
                }
            %>
    </tr>
    </thead>
    <tbody>
        <%
            for(int i=2;i<=9; i++){
        %>
        <tr>
            <%
                for(int j=2; j<=9; j++){
            %>
            <td><%=j%>*<%=i%>=<%=j*i%></td>
            <%
                }
            %>
        </tr>
        <%
            }
        %>
    </tbody>
</table>



</body>
</html>
