<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"  %>
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/style.css"/>
<header style="padding:16px 0; border-bottom:1px solid #e5e7eb; margin-bottom:16px;">
  <div style="display:flex; align-items:center; gap:12px;">
    <a href="${pageContext.request.contextPath}/todo/list" style="text-decoration:none;font-weight:700;">TODO</a>
    <nav style="font-size:14px; color:#6b7280;">
      <a href="${pageContext.request.contextPath}/todo/list">목록</a> ·
      <a href="${pageContext.request.contextPath}/todo/write">작성</a>
    </nav>
  </div>
</header>
