<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${pr.totalPages > 1}">
  <div style="display:flex; gap:6px; justify-content:center; margin-top:16px; flex-wrap:wrap;">
    <c:set var="firstPage" value="1"/>
    <c:set var="lastPage"  value="${pr.totalPages}"/>

    <!-- Prev -->
    <c:if test="${pr.page > 1}">
      <c:url var="prevUrl" value="${basePath}">
        <c:param name="q"        value="${param.q}"/>
        <c:param name="status"   value="${param.status}"/>
        <c:param name="category" value="${param.category}"/>
        <c:param name="priority" value="${param.priority}"/>
        <c:param name="due"      value="${param.due}"/>
        <c:param name="sort"     value="${empty param.sort ? 'createdAt' : param.sort}"/>
        <c:param name="order"    value="${empty param.order ? 'desc' : param.order}"/>
        <c:param name="size"     value="${empty param.size ? pr.size : param.size}"/>
        <c:param name="page"     value="${pr.page - 1}"/>
      </c:url>
      <a href="${prevUrl}" class="page-btn">« Prev</a>
    </c:if>

    <!-- Pages -->
    <c:forEach var="i" begin="${firstPage}" end="${lastPage}">
      <c:url var="iUrl" value="${basePath}">
        <c:param name="q"        value="${param.q}"/>
        <c:param name="status"   value="${param.status}"/>
        <c:param name="category" value="${param.category}"/>
        <c:param name="priority" value="${param.priority}"/>
        <c:param name="due"      value="${param.due}"/>
        <c:param name="sort"     value="${empty param.sort ? 'createdAt' : param.sort}"/>
        <c:param name="order"    value="${empty param.order ? 'desc' : param.order}"/>
        <c:param name="size"     value="${empty param.size ? pr.size : param.size}"/>
        <c:param name="page"     value="${i}"/>
      </c:url>
      <a href="${iUrl}" class="page-btn ${i == pr.page ? 'active' : ''}">${i}</a>
    </c:forEach>

    <!-- Next -->
    <c:if test="${pr.page < pr.totalPages}">
      <c:url var="nextUrl" value="${basePath}">
        <c:param name="q"        value="${param.q}"/>
        <c:param name="status"   value="${param.status}"/>
        <c:param name="category" value="${param.category}"/>
        <c:param name="priority" value="${param.priority}"/>
        <c:param name="due"      value="${param.due}"/>
        <c:param name="sort"     value="${empty param.sort ? 'createdAt' : param.sort}"/>
        <c:param name="order"    value="${empty param.order ? 'desc' : param.order}"/>
        <c:param name="size"     value="${empty param.size ? pr.size : param.size}"/>
        <c:param name="page"     value="${pr.page + 1}"/>
      </c:url>
      <a href="${nextUrl}" class="page-btn">Next »</a>
    </c:if>
  </div>
</c:if>
<style>
  .page-btn{padding:6px 10px;border:1px solid #e5e7eb;border-radius:8px;text-decoration:none;color:#111827;}
  .page-btn.active{background:#111827;color:#fff;border-color:#111827;}
  .page-btn:hover{background:#f3f4f6;}
</style>
