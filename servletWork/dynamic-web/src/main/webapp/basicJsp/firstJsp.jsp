<%--
  Created by IntelliJ IDEA.
  User: yerin
  Date: 2025-08-22
  Time: 오후 1:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        h1 {
            font-family: 굴림체;
        }
    </style>
</head>
<hr>
    <h1>FirstJsp</h1>
    <%
    for(int i=1; i<=10; i++){
        %>
    <hr size="100px" color="pink"></hr>
    <%
    }
    %>
<body>

</body>
<script>
  function showMessage(message) {

  }
</script>
</html>
