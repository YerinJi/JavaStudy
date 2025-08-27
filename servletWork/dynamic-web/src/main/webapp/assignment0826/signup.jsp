<%--
  Created by IntelliJ IDEA.
  User: yerin
  Date: 2025-08-27
  Time: 오전 9:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="common/top.jsp" %>
<%
    request.setAttribute("active", "SignUp");
    request.setAttribute("pageTitle", "Sign up · Mini Portal");
%>

<div class="row justify-content-center">
    <div class="col-lg-7 col-xl-6">
        <h2 class="h3 mb-3 text-center">회원가입</h2>
        <form class="needs-validation" novalidate method="post" action="signup_result.jsp">
            <div class="row g-3">
                <div class="col-12">
                    <label for="name" class="form-label">이름</label>
                    <input id="name" name="name" type="text" class="form-control" required placeholder="홍길동" aria-required="true">
                    <div class="invalid-feedback">이름을 입력하세요.</div>
                </div>
                <div class="col-12">
                    <label for="email2" class="form-label">이메일</label>
                    <input id="email2" name="email" type="email" class="form-control" required placeholder="name@example.com" aria-required="true">
                    <div class="invalid-feedback">올바른 이메일을 입력하세요.</div>
                </div>
                <div class="col-sm-6">
                    <label for="pw2" class="form-label">비밀번호</label>
                    <input id="pw2" name="pw" type="password" class="form-control" required minlength="6" placeholder="최소 6자" aria-required="true">
                    <div class="invalid-feedback">비밀번호는 최소 6자 이상입니다.</div>
                </div>
                <div class="col-sm-6">
                    <label for="pw3" class="form-label">비밀번호 확인</label>
                    <input id="pw3" name="pwConfirm" type="password" class="form-control" required minlength="6" placeholder="비밀번호 확인" aria-required="true">
                    <div class="invalid-feedback">비밀번호 확인이 필요합니다.</div>
                </div>
            </div>

            <button class="btn btn-primary mt-3 w-100" type="submit">
                <i class="bi bi-person-plus me-1"></i> 회원가입
            </button>
        </form>
    </div>
</div>

<jsp:include page="common/bottom.jsp"/>
