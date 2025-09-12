<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head><title>Members</title></head>
<body>
<h2>Member List</h2>
<table border="1" cellpadding="8">
    <tr><th>ID</th><th>Name</th></tr>
    <c:forEach var="m" items="${members}">
        <tr>
            <td>${m.id}</td>
            <td>${m.name}</td>
        </tr>
    </c:forEach>
</table>
<p><a href="<c:url value='/'/>">Home</a></p>
</body>
</html>
