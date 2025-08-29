<%--
  Created by IntelliJ IDEA.
  User: yerin
  Date: 2025-08-29
  Time: 오전 11:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>process.jsp</h2>
<%
  request.setCharacterEncoding("UTF-8");
  String name = request.getParameter("username");
  request.setAttribute("name",name);
    //  response.sendRedirect("result.jsp");
    //JSP/Servlet에서 클라이언트 요청으로 서버내부에서 다른자원 (Jsp,Html,Servlet)으로 전달하는 기능을 forward라고함
    // forward를 하면 서버내부로 자원을 이동하기 때문에 브라우저 주소창 변화 없이 서버내부로 이동
  RequestDispatcher rd = request.getRequestDispatcher("result.jsp");
  rd.forward(request, response);
%>

</body>
</html>
