<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <title>Bootstrap Example</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>

<div class="container">
    <h2>JSTL-forward</h2>
    <p>게시판</p>
    <table class="table table-hover">
        <thead>
        <tr >
            <th>NUMBER</th>
            <th>ID</th>
            <th>TITLE</th>
            <th>CONTENT</th>
            <th>CREATED_AT</th>
        </tr>
        </thead>

        <tbody>
        <c:forEach var="li" items="${list}" varStatus="cnt">
            <c:choose>
            <c:when test="${cnt.count mod 2 eq 0}">
                <tr>
                    <td>${cnt.count}</td>
                    <td>${li.id}</td>
                    <td>${li.title}</td>
                    <td>${li.content}</td>
                    <td>${li.createdAt}</td>
                </tr>
            </c:when>
            <c:when test="${cnt.count mod 3 eq 0}">
                <tr class="table-primary">
                    <td>${cnt.count}</td>
                    <td>${li.id}</td>
                    <td>${li.title}</td>
                    <td>${li.content}</td>
                    <td>${li.createdAt}</td>
                </tr>
            </c:when>
            <c:otherwise>
                <tr class="table-success">
                    <td>${cnt.count}</td>
                    <td>${li.id}</td>
                    <td>${li.title}</td>
                    <td>${li.content}</td>
                    <td>${li.createdAt}</td>
                </tr>
            </c:otherwise>
            </c:choose>
        </c:forEach>
        </tbody>
    </table>
</div>

</body>
</html>
