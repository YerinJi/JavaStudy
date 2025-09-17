<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ include file="header.jsp" %>

<div class="container mt-4">
    <h2 class="mb-3">Wish List</h2>

    <form method="get" action="<c:url value='/list'/>" class="row g-2 mb-3">
        <div class="col-auto">
            <select name="type" class="form-select form-select-sm">
                <option value="title"          <c:if test="${type=='title'}">selected</c:if>>제목</option>
                <option value="author"        <c:if test="${type=='author'}">selected</c:if>>저자</option>
                <option value="publisher"         <c:if test="${type=='publisher'}">selected</c:if>>출판사</option>
            </select>
        </div>
        <div class="col-auto">
            <input type="text" name="q" value="${fn:escapeXml(q)}"
                   class="form-control form-control-sm" placeholder="검색어">
        </div>
        <div class="col-auto">
            <button class="btn btn-sm btn-primary">검색</button>
        </div>
    </form>

    <table class="table table-striped align-middle">
        <thead class="table-dark">
        <tr>
            <th>#</th><th>제목</th><th>저자</th><th>출판사</th><th>가격</th><th>등록일</th><th>수정/삭제</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="book" items="${bookList}">
            <tr>
                <td>${book.id}</td>
                <td>
                    <a href="<c:url value='/view/${book.id}'/>" class="text-decoration-none">
                            ${fn:escapeXml(book.title)}
                    </a>
                </td>
                <td>${fn:escapeXml(book.author)}</td>
                <td>${book.publisher}</td>
                <td>${book.price}원</td>
                <td>${book.createdAtString}</td>
                <td>
                    <a href="<c:url value='/edit/${book.id}'/>" class="btn btn-sm btn-primary">수정</a>
                    <a href="<c:url value='/delete/${book.id}'/>" class="btn btn-sm btn-danger">삭제</a>
                </td>
            </tr>
        </c:forEach>
        <c:if test="${empty bookList}">
            <tr><td colspan="6" class="text-center py-5">해당 도서가 없습니다.</td></tr>
        </c:if>
        </tbody>
    </table>

    <%-- 페이징 --%>
    <div class="d-flex justify-content-between">
        <a href="<c:url value='/write'/>" class="btn btn-success">도서 등록</a>

        <nav aria-label="pagination">
            <ul class="pagination pagination-sm mb-0">
                <li class="page-item ${pagination.hasPrev ? '' : 'disabled'}">
                    <a class="page-link"
                       href="<c:url value='/list'>
                             <c:param name='page' value='${pagination.prevPage}'/>
                             <c:param name='size' value='${pagination.size}'/>
                             <c:param name='type' value='${type}'/>
                             <c:param name='q'    value='${q}'/>
                           </c:url>">«</a>
                </li>

                <c:forEach var="p" begin="${pagination.startPage}" end="${pagination.endPage}">
                    <li class="page-item ${p == pagination.page ? 'active' : ''}">
                        <a class="page-link"
                           href="<c:url value='/list'>
                                 <c:param name='page' value='${p}'/>
                                 <c:param name='size' value='${pagination.size}'/>
                                 <c:param name='type' value='${type}'/>
                                 <c:param name='q'    value='${q}'/>
                               </c:url>">${p}</a>
                    </li>
                </c:forEach>

                <li class="page-item ${pagination.hasNext ? '' : 'disabled'}">
                    <a class="page-link"
                       href="<c:url value='/list'>
                             <c:param name='page' value='${pagination.nextPage}'/>
                             <c:param name='size' value='${pagination.size}'/>
                             <c:param name='type' value='${type}'/>
                             <c:param name='q'    value='${q}'/>
                           </c:url>">»</a>
                </li>
            </ul>
        </nav>
    </div>
</div>

<%@ include file="footer.jsp" %>
