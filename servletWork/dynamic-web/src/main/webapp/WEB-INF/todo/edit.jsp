<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>TODO 수정</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/style.css"/>
  <style>
    .wrap{max-width:720px;margin:0 auto;}
    .field{margin:10px 0;}
    label{display:block;margin-bottom:6px;font-weight:600;}
    input[type=text], textarea, select, input[type=datetime-local]{
      width:100%;padding:10px;border:1px solid #e5e7eb;border-radius:10px;
    }
    .err{color:#b91c1c;font-size:12px;margin-top:4px;}
    .actions{display:flex; gap:8px; margin-top:16px;}
    .btn{padding:8px 12px;border:1px solid #e5e7eb;border-radius:8px;background:#fff;text-decoration:none;color:#111827;}
    .btn.primary{border-color:#111827;background:#111827;color:#fff;}
  </style>
</head>
<body>
<jsp:include page="/WEB-INF/todo/header.jsp"/>

<div class="wrap">
  <h2>할 일 수정</h2>
  <form method="post" action="${pageContext.request.contextPath}/todo/edit">
    <input type="hidden" name="id" value="${todo.id}"/>

    <div class="field">
      <label>제목 *</label>
      <input type="text" name="title" maxlength="100" value="${empty form.title ? todo.title : form.title}"/>
      <c:if test="${not empty errors.title}"><div class="err">${errors.title}</div></c:if>
    </div>

    <div class="field">
      <label>내용</label>
      <textarea name="description" rows="6"><c:out value="${empty form.description ? todo.description : form.description}"/></textarea>
      <c:if test="${not empty errors.description}"><div class="err">${errors.description}</div></c:if>
    </div>

    <div class="field">
      <label>카테고리</label>
      <input type="text" name="category" maxlength="40" value="${empty form.category ? todo.category : form.category}"/>
      <c:if test="${not empty errors.category}"><div class="err">${errors.category}</div></c:if>
    </div>

    <div class="field">
      <label>우선순위(1~5) *</label>
      <select name="priority">
        <c:set var="pri" value="${empty form.priority ? todo.priority : form.priority}"/>
        <c:forEach var="i" begin="1" end="5">
          <option value="${i}" ${pri==i?'selected':''}>${i}</option>
        </c:forEach>
      </select>
      <c:if test="${not empty errors.priority}"><div class="err">${errors.priority}</div></c:if>
    </div>

    <div class="field">
      <label>상태 *</label>
      <select name="status">
        <c:set var="st" value="${empty form.status ? todo.status : form.status}"/>
        <option value="TODO"  ${st=='TODO'?'selected':''}>TODO</option>
        <option value="DOING" ${st=='DOING'?'selected':''}>DOING</option>
        <option value="DONE"  ${st=='DONE'?'selected':''}>DONE</option>
      </select>
      <c:if test="${not empty errors.status}"><div class="err">${errors.status}</div></c:if>
    </div>

    <div class="field">
      <label>마감일</label>
      <!-- 컨트롤러에서 form.dueAt 또는 todo.dueAt을 'yyyy-MM-ddTHH:mm' 문자열로 세팅해주면 그대로 표시됨 -->
      <input type="datetime-local" name="dueAt" value="${empty form.dueAt ? dueAtForEdit : form.dueAt}"/>
      <c:if test="${not empty errors.dueAt}"><div class="err">${errors.dueAt}</div></c:if>
    </div>

    <div class="actions">
      <button type="submit" class="btn primary">저장</button>
      <a class="btn" href="${pageContext.request.contextPath}/todo/view?id=${todo.id}">취소</a>
    </div>
  </form>
</div>
</body>
</html>
