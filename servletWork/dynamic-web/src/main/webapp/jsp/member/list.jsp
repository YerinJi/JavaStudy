<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<h3>게시판 목록</h3>
<form method="get" action="${pageContext.request.contextPath}/board">
  <input type="hidden" name="action" value="list"/>
  <select name="type">
    <option value="title" ${type=="title"?"selected":""}>제목</option>
    <option value="content" ${type=="content"?"selected":""}>내용</option>
    <option value="writer" ${type=="writer"?"selected":""}>작성자</option>
  </select>
  <input name="q" value="${q}" placeholder="검색어"/>
  <button>검색</button>
</form>
<table border="1" cellpadding="6" cellspacing="0">
  <thead><tr><th>ID</th><th>제목</th><th>작성일</th><th>조회</th><th>관리</th></tr></thead>
  <tbody>
  <c:choose>
    <c:when test="${empty boards}"><tr><td colspan="5">데이터가 없습니다.</td></tr></c:when>
    <c:otherwise>
      <c:forEach var="b" items="${boards}">
        <tr>
          <td>${b.id}</td>
          <td>
            <c:url var="viewUrl" value="/board"><c:param name="action" value="view"/><c:param name="id" value="${b.id}"/></c:url>
            <a href="${viewUrl}">${b.title}</a>
          </td>
          <td>${b.createdAt}</td>
          <td>${b.viewCnt}</td>
          <td>
            <c:url var="delUrl" value="/board"><c:param name="action" value="delete"/><c:param name="id" value="${b.id}"/></c:url>
            <a href="${delUrl}" onclick="return confirm('삭제할까요?')">삭제</a>
          </td>
        </tr>
      </c:forEach>
    </c:otherwise>
  </c:choose>
  </tbody>
</table>
<c:set var="pr" value="${pageResult}"/>
<div>
  <c:if test="${pr.hasPrev}">
    <c:url var="prev" value="/board"><c:param name="action" value="list"/><c:param name="page" value="${pr.page-1}"/><c:param name="size" value="${pr.size}"/><c:param name="type" value="${type}"/><c:param name="q" value="${q}"/></c:url>
    <a href="${prev}">이전</a>
  </c:if>
  ${pr.page} / ${pr.totalPages}
  <c:if test="${pr.hasNext}">
    <c:url var="next" value="/board"><c:param name="action" value="list"/><c:param name="page" value="${pr.page+1}"/><c:param name="size" value="${pr.size}"/><c:param name="type" value="${type}"/><c:param name="q" value="${q}"/></c:url>
    <a href="${next}">다음</a>
  </c:if>
</div>
<c:url var="writeUrl" value="/board"><c:param name="action" value="write"/></c:url>
<a href="${writeUrl}">글쓰기</a>