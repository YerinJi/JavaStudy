<%@ page contentType="text/html; charset=UTF-8" %>
<form method="post" action="${pageContext.request.contextPath}/board?action=edit">
  <input type="hidden" name="id" value="${board.id}">
  <input name="title" value="${board.title}" required>
  <textarea name="content" required>${board.content}</textarea>
  <button type="submit">수정</button>
</form>