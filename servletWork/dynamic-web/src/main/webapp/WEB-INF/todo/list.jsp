<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"  %>
<%@ taglib prefix="fn"  uri="http://java.sun.com/jsp/jstl/functions" %>
<jsp:useBean id="now" class="java.util.Date"/>

<html>
<head>
    <title>TODO 목록</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/style.css"/>
    <style>
        .toolbar{display:grid;grid-template-columns:1fr auto;gap:12px;align-items:end;margin:12px 0;}
        .filters{display:grid;grid-template-columns:repeat(8,minmax(0,1fr));gap:8px;}
        .filters input, .filters select{padding:8px;border:1px solid #e5e7eb;border-radius:8px;}
        table{width:100%;border-collapse:collapse;margin-top:12px;}
        th,td{padding:10px;border-bottom:1px solid #e5e7eb;text-align:left;font-size:14px;}
        tr.overdue{background:#fff7f7;}
        .badge{padding:2px 8px;border-radius:999px;font-size:12px;}
        .b-todo{background:#e5e7eb;}
        .b-doing{background:#dbeafe;}
        .b-done{background:#dcfce7;}
        .actions a, .actions form{display:inline-block;margin-right:6px;}
        .actions button{padding:6px 10px;border:1px solid #e5e7eb;background:#fff;border-radius:8px;cursor:pointer;}
    </style>
</head>
<body>
<jsp:include page="/WEB-INF/todo/header.jsp"/>

<section class="toolbar">
    <form method="get" action="${pageContext.request.contextPath}/todo/list" class="filters">
        <input type="text" name="q" placeholder="검색어(제목/내용)" value="${fn:escapeXml(param.q)}"/>

        <select name="status">
            <c:set var="pStatus" value="${empty param.status ? 'all' : param.status}"/>
            <option value="all"  ${pStatus=='all'?'selected':''}>상태(전체)</option>
            <option value="TODO" ${pStatus=='TODO'?'selected':''}>TODO</option>
            <option value="DOING"${pStatus=='DOING'?'selected':''}>DOING</option>
            <option value="DONE" ${pStatus=='DONE'?'selected':''}>DONE</option>
        </select>

        <input type="text" name="category" placeholder="카테고리" value="${fn:escapeXml(param.category)}"/>

        <select name="priority">
            <c:set var="pPriority" value="${empty param.priority ? 'all' : param.priority}"/>
            <option value="all" ${pPriority=='all'?'selected':''}>우선순위(전체)</option>
            <c:forEach var="i" begin="1" end="5">
                <option value="${i}" ${pPriority==i? 'selected':''}>${i}</option>
            </c:forEach>
        </select>

        <select name="due">
            <c:set var="pDue" value="${empty param.due ? 'all' : param.due}"/>
            <option value="all"     ${pDue=='all'?'selected':''}>마감일(전체)</option>
            <option value="overdue" ${pDue=='overdue'?'selected':''}>지연</option>
            <option value="today"   ${pDue=='today'?'selected':''}>오늘</option>
            <option value="week"    ${pDue=='week'?'selected':''}>7일 이내</option>
        </select>

        <select name="sort">
            <c:set var="pSort" value="${empty param.sort ? 'createdAt' : param.sort}"/>
            <option value="createdAt" ${pSort=='createdAt'?'selected':''}>정렬: 생성일</option>
            <option value="dueAt"     ${pSort=='dueAt'?'selected':''}>정렬: 마감일</option>
            <option value="priority"  ${pSort=='priority'?'selected':''}>정렬: 우선순위</option>
        </select>

        <select name="order">
            <c:set var="pOrder" value="${empty param.order ? 'desc' : param.order}"/>
            <option value="desc" ${pOrder=='desc'?'selected':''}>내림차순</option>
            <option value="asc"  ${pOrder=='asc'?'selected':''}>오름차순</option>
        </select>

        <select name="size">
            <c:set var="pSize" value="${empty param.size ? (empty pr.size ? 10 : pr.size) : param.size}"/>
            <option value="10" ${pSize=='10'?'selected':''}>10개</option>
            <option value="20" ${pSize=='20'?'selected':''}>20개</option>
            <option value="50" ${pSize=='50'?'selected':''}>50개</option>
        </select>

        <button type="submit" style="padding:8px 12px;border:1px solid #111827;background:#111827;color:#fff;border-radius:8px;">검색</button>
    </form>

    <div>
        <a href="${pageContext.request.contextPath}/todo/write" style="padding:8px 12px;border:1px solid #e5e7eb;border-radius:8px;text-decoration:none;">+ 새 할 일</a>
    </div>
</section>

<c:if test="${empty pr || empty pr.items}">
    <p style="color:#6b7280;">표시할 항목이 없습니다.</p>
</c:if>

<c:if test="${not empty pr && not empty pr.items}">
    <p style="font-size:14px;color:#6b7280;">
        총 <strong>${pr.total}</strong>건 · ${pr.page}/${pr.totalPages} 페이지
    </p>

    <table>
        <thead>
        <tr>
            <th>ID</th>
            <th>제목</th>
            <th>카테고리</th>
            <th>우선</th>
            <th>상태</th>
            <th>마감일</th>
            <th>생성일</th>
            <th>액션</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="t" items="${pr.items}">
            <c:set var="isOverdue" value="${not empty t.dueAt and t.dueAt.time lt now.time and t.status ne 'DONE'}"/>
            <tr class="${isOverdue ? 'overdue' : ''}">
                <td>${t.id}</td>
                <td>
                    <a href="${pageContext.request.contextPath}/todo/view?id=${t.id}">
                        <c:out value="${t.title}"/>
                    </a>
                </td>
                <td><c:out value="${t.category}"/></td>
                <td>${t.priority}</td>
                <td>
                    <c:choose>
                        <c:when test="${t.status=='TODO'}"><span class="badge b-todo">TODO</span></c:when>
                        <c:when test="${t.status=='DOING'}"><span class="badge b-doing">DOING</span></c:when>
                        <c:otherwise><span class="badge b-done">DONE</span></c:otherwise>
                    </c:choose>
                </td>
                <td>
                    <c:choose>
                        <c:when test="${empty t.dueAt}">—</c:when>
                        <c:otherwise><fmt:formatDate value="${t.dueAt}" pattern="yyyy-MM-dd HH:mm"/></c:otherwise>
                    </c:choose>
                </td>
                <td><fmt:formatDate value="${t.createdAt}" pattern="yyyy-MM-dd HH:mm"/></td>
                <td class="actions">
                    <a href="${pageContext.request.contextPath}/todo/edit?id=${t.id}">수정</a>

                    <form method="post" action="${pageContext.request.contextPath}/todo/toggle" style="display:inline;">
                        <input type="hidden" name="id" value="${t.id}"/>
                        <button type="submit">토글</button>
                    </form>

                    <form method="post" action="${pageContext.request.contextPath}/todo/delete" style="display:inline;" onsubmit="return confirm('삭제할까요?');">
                        <input type="hidden" name="id" value="${t.id}"/>
                        <button type="submit">삭제</button>
                    </form>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <jsp:include page="/WEB-INF/todo/pagination.jsp">
        <jsp:param name="basePath" value="${pageContext.request.contextPath}/todo/list"/>
        <jsp:param name="pr"       value="${pr}"/>
    </jsp:include>
</c:if>

</body>
</html>
