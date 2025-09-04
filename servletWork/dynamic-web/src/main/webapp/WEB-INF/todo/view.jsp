<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"  %>
<html>
<head>
    <title>TODO 상세</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/style.css"/>
    <style>
        .wrap{max-width:820px;margin:0 auto;}
        .meta{color:#6b7280;font-size:14px;margin-bottom:10px;}
        .box{border:1px solid #e5e7eb;border-radius:12px;padding:16px;}
        .row{display:grid;grid-template-columns:140px 1fr;gap:12px;margin:8px 0;}
        .actions{display:flex; gap:8px; margin-top:16px;}
        .btn{padding:8px 12px;border:1px solid #e5e7eb;border-radius:8px;background:#fff;text-decoration:none;color:#111827;}
        .btn.primary{border-color:#111827;background:#111827;color:#fff;}
    </style>
</head>
<body>
<jsp:include page="/WEB-INF/todo/header.jsp"/>

<div class="wrap">
    <h2 style="margin-bottom:8px;"><c:out value="${todo.title}"/></h2>
    <div class="meta">
        ID ${todo.id} · 생성 <fmt:formatDate value="${todo.createdAt}" pattern="yyyy-MM-dd HH:mm"/>
        · 수정 <fmt:formatDate value="${todo.updatedAt}" pattern="yyyy-MM-dd HH:mm"/>
    </div>

    <div class="box">
        <div class="row"><div>상태</div><div>${todo.status}</div></div>
        <div class="row"><div>우선순위</div><div>${todo.priority}</div></div>
        <div class="row"><div>카테고리</div><div><c:out value="${todo.category}"/></div></div>
        <div class="row">
            <div>마감일</div>
            <div>
                <c:choose>
                    <c:when test="${empty todo.dueAt}">—</c:when>
                    <c:otherwise><fmt:formatDate value="${todo.dueAt}" pattern="yyyy-MM-dd HH:mm"/></c:otherwise>
                </c:choose>
            </div>
        </div>
        <div class="row" style="align-items:start;">
            <div>내용</div>
            <div style="white-space:pre-wrap;"><c:out value="${todo.description}"/></div>
        </div>

        <div class="actions">
            <a class="btn" href="${pageContext.request.contextPath}/todo/edit?id=${todo.id}">수정</a>

            <form method="post" action="${pageContext.request.contextPath}/todo/toggle" style="display:inline;">
                <input type="hidden" name="id" value="${todo.id}"/>
                <button type="submit" class="btn">상태 토글</button>
            </form>

            <form method="post" action="${pageContext.request.contextPath}/todo/delete" style="display:inline;" onsubmit="return confirm('삭제할까요?');">
                <input type="hidden" name="id" value="${todo.id}"/>
                <button type="submit" class="btn">삭제</button>
            </form>

            <a class="btn primary" href="${pageContext.request.contextPath}/todo/list">목록으로</a>
        </div>
    </div>
</div>
</body>
</html>
