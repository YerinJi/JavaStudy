<%@ include file="header.jsp" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<div class="container mt-4">
    <h2 class="mb-4">도서 수정</h2>
    <form action="/edit" method="post">
        <input type="hidden" name="id" value="${book.id}">
        <div class="mb-3">
            <label for="title" class="form-label">제목</label>
            <input type="text" class="form-control" id="title" name="title" value="${book.title}" required>
        </div>
        <div class="mb-3">
            <label for="author" class="form-label">저자</label>
            <input type="text" class="form-control" id="author" name="author" value="${book.author}" required>
        </div>
        <div class="mb-3">
            <label for="publisher" class="form-label">출판사</label>
            <input type="text" class="form-control" id="publisher" name="publisher" value="${book.publisher}" required>
        </div>
        <div class="mb-3">
            <label for="price" class="form-label">가격</label>
            <input type="text" class="form-control" id="price" name="price" value="${book.price}" required>
        </div>
        <button type="submit" class="btn btn-primary">저장</button>
        <a href="/list" class="btn btn-secondary">취소</a>

    </form>
</div>
<%@ include file="footer.jsp" %>