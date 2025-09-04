<%@ page contentType="text/html; charset=UTF-8" %>
<form method="post" action="${pageContext.request.contextPath}/board?action=write">
    <input name="title" placeholder="제목" required><br>
    <textarea name="content" placeholder="내용" required></textarea><br>
    <button type="submit">등록</button>
</form>
