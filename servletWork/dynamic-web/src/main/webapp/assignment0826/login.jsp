
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    request.setAttribute("active", "Login");
    request.setAttribute("pageTitle", "Login · Mini Portal");
%>
<%@ include file="common/top.jsp" %>

<div class="row justify-content-center">
    <div class="col-md-6 col-lg-5">
        <h2 class="h3 mb-3 text-center">Login</h2>
        <form class="needs-validation" novalidate method="post" action="index.jsp" aria-describedby="loginHelp">
            <div class="mb-3">
                <label for="email" class="form-label">Email</label>
                <input id="email" name="email" type="email" class="form-control" required
                       placeholder="name@example.com" autocomplete="username"
                       aria-required="true">
                <div class="invalid-feedback">올바른 이메일을 입력하세요.</div>
            </div>

            <div class="mb-3">
                <label for="pw" class="form-label">Password</label>
                <input id="pw" name="pw" type="password" class="form-control" required minlength="6"
                       placeholder="••••••" autocomplete="current-password" aria-required="true">
                <div class="invalid-feedback">비밀번호는 최소 6자 이상입니다.</div>
            </div>

            <div class="d-flex justify-content-between align-items-center mb-3">
                <div class="form-check">
                    <input class="form-check-input" type="checkbox" value="1" id="remember">
                    <label class="form-check-label" for="remember">Remember me</label>
                </div>
                <a href="#" class="small">Forgot password?</a>
            </div>

            <button class="btn btn-primary w-100" type="submit" aria-label="로그인">
                <i class="bi bi-box-arrow-in-right me-1"></i> Login
            </button>
        </form>
        <p id="loginHelp" class="form-text mt-3 text-center">
            계정이 없나요? <a href="signup.jsp" class="link-primary">Sign up</a>
        </p>
    </div>
</div>

<jsp:include page="common/bottom.jsp"/>
