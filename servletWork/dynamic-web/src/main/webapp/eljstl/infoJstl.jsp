<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: yerin
  Date: 2025-09-04
  Time: 오후 3:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Info-JSTL</h2>
<%-- ${info.id}는 getId와 같은 형태 --%>
<c:out value="id"/>: ${info.id}<br>
<c:out value="title"/>: ${info.title}<br>
<c:out value="content"/>: ${info.content}<br>
<c:out value="createdAt"/>: ${info.createdAt}<br>
</body>
</html>
