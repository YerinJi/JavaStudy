
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ include file="common/top.jsp" %>

<h2>Sign up Result</h2>
<ul class="list-group list-group-flush">
    <li class="list-group-item">Name: <%=request.getParameter("name")%></li>
    <li class="list-group-item">Email: <%=request.getParameter("email")%></li>
    <li class="list-group-item">Password: <%=request.getParameter("pw")%></li>
</ul>

<jsp:include page="common/bottom.jsp"/>
