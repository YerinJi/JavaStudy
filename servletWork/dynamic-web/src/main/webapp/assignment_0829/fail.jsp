<%@ page contentType="text/html; charset=UTF-8" %>
<h2>로그인 실패</h2>
<%
    String err = request.getParameter("err");
    if ("1".equals(err)) {
%>
<p style="color:red;">아이디 또는 비밀번호가 올바르지 않습니다.</p>
<% } %>
<a href="/assignment_0829/login.jsp">로그인 페이지로</a>
<%= request.getAttribute("loginId") %>
