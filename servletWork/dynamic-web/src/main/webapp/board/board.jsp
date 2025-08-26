<%@ include file="/include/header.jsp" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ page session="true" %>
<%
  // 로그인이 안되어 있을 경우
  if (session.getAttribute("user") == null) {
    response.sendRedirect("login.jsp");
    return;
  }
%>
<div class="container mt-5">
  <h2>자유게시판</h2>
  <table class="table table-hover">
    <thead class="thead-light">
    <tr>
      <th>#</th>
      <th>제목</th>
      <th>작성자</th>
      <th>날짜</th>
    </tr>
    </thead>
    <tbody>
    <tr onclick="alert('게시글 1 클릭됨')">
      <td>1</td>
      <td>첫 번째 글</td>
      <td>관리자</td>
      <td>2025-05-01</td>
    </tr>
    <tr onclick="alert('게시글 2 클릭됨')">
      <td>2</td>
      <td>두 번째 글</td>
      <td>관리자</td>
      <td>2025-05-02</td>
    </tr>
    </tbody>
  </table>
</div>
<%@ include file="/include/footer.jsp" %>



