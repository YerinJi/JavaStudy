
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/include/header.jsp" %>
<%
  String message = "";
  if ("POST".equalsIgnoreCase(request.getMethod())) {
    String username = request.getParameter("username");
    String password = request.getParameter("password");
    // username이 admin이고 password가 1234이면
    if ("admin".equals(username) && "1234".equals(password)) {
      //로그인을 성공했을 때... session에 username을 저장한다.
      session.setAttribute("user", username); //user는 key username은 value
      // response는 응답객체이다. 그래서 응답 객체안에 stream 데이터 기반으로 welcome.jsp로 이동한다.
      response.sendRedirect("welcome.jsp");
      return;
    } else {
      message = "Invalid credentials";
    }
  }
%>
<div class="container mt-5">
  <h2>Login</h2>
  <form method="post">
    <div class="form-group">
      <label>Username</label>
      <input type="text" name="username" class="form-control" required>
    </div>
    <div class="form-group">
      <label>Password</label>
      <input type="password" name="password" class="form-control" required>
    </div>
    <button type="submit" class="btn btn-primary">Login</button>
    <div class="text-danger mt-2"><%= message %></div>
  </form>
</div>
<%@ include file="/include/footer.jsp" %>


