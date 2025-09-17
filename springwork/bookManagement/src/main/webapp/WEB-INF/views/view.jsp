<%@ include file="header.jsp" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<div class="container mt-4">
    <h2 class="mb-4">도서 상세보기</h2>
    <div class="card">
        <div class="card-header bg-dark text-white">
            제목: ${book.title}
        </div>
        <div class="card-body">
            <h5 class="card-title">작성자: ${book.author}</h5>
            <p class="card-text">출판사: ${book.publisher}</p>
            <p class="card-text">가격: ${book.price}</p>
            <p class="text-muted">작성일: ${book.createdAt}</p>
            <a href="/list" class="btn btn-secondary">목록으로</a>
            <a href="/edit/${book.id}" class="btn btn-primary">수정</a>
            <a href="/delete/${book.id}" class="btn btn-danger">삭제</a>
        </div>
    </div>
</div>
<%@ include file="footer.jsp" %>

