<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<meta charset="UTF-8">

<h3>로그인</h3>
<c:if test="${not empty error}"><p style="color:red">${error}</p></c:if>
<form method="post" action="${pageContext.request.contextPath}/member">
    <input type="hidden" name="action" value="login"/>
    아이디 <input name="username"/><br/>
    비밀번호 <input type="password" name="password"/><br/>
    <button type="submit">로그인</button>
</form>
<a href="${pageContext.request.contextPath}/member?action=join">회원가입</a>
