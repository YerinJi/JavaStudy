<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:choose>
  <c:when test="${empty board}"><p style="color:red">board가 비었습니다.</p></c:when>
  <c:otherwise>
    <h3>${board.title}</h3>
    <pre>${board.content}</pre>
    <p>id=${board.id}, 조회수=${board.viewCnt}, 작성일=${board.createdAt}</p>
    <c:url var="listUrl" value="/board"><c:param name="action" value="list"/></c:url>
    <a href="${listUrl}">목록</a>
  </c:otherwise>
</c:choose>