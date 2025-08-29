<%--
  Created by IntelliJ IDEA.
  User: yerin
  Date: 2025-08-28
  Time: 오후 9:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<%
  String id = request.getParameter("user_id");
  String pw = request.getParameter("user_passwd");
  String checker = request.getParameter("checker");
  String ctx = request.getContextPath();



  if ("user".equals(id) && "1234".equals(pw)) {  // null 안전
    request.getSession().setAttribute("id", id);

    Cookie cookie = new Cookie("id", id);
    cookie.setMaxAge("on".equals(checker) ? 600 : 0);
    cookie.setPath(request.getContextPath());
    response.addCookie(cookie);

    response.sendRedirect(ctx + "/assignment0828/me.jsp");
    return;
  }
  if(!"1234".equals(pw)){
%>
<script>
  alert('비밀번호가 틀렸습니다.');
  location.replace('<%=ctx%>/assignment0828/login.jsp');
</script>
<%
  }
%>
<body>


</body>
</html>
