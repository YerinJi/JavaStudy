<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%@ include file="header.jsp" %>

<div class="container mt-4">
    <h2 class="mb-4">📖 도서 목록</h2>
    <table class="table table-hover table-striped">
        <thead class="thead-dark">
        <tr>
            <th>번호</th>
            <th>제목</th>
            <th>저자</th>
            <th>출판사</th>
            <th>가격</th>
            <th>등록일</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="book" items="${bookList}">
            <tr onclick="location.href='/detail/${book.id}'" style="cursor:pointer;">
                <td>${book.id}</td>
                <td>${book.title}</td>
                <td>${book.author}</td>
                <td>${book.publisher}</td>
                <td>${book.price}원</td>
                <td><fmt:formatDate value="${book.created_at}" pattern="yyyy-MM-dd"/></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<%@ include file="footer.jsp" %>