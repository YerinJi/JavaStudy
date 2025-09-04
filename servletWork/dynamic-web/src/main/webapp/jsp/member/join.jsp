<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h3>회원가입</h3>
<c:if test="${not empty error}"><p style="color:red">${error}</p></c:if>
<form method="post" action="${pageContext.request.contextPath}/member">
  <input type="hidden" name="action" value="join"/>
  아이디 <input name="username"/><br/>
  비밀번호 <input type="password" name="password"/><br/>
  닉네임 <input name="nickname"/><br/>
  <button type="submit">가입</button>
</form>
