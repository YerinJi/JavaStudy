<%@ page contentType="text/html; charset=UTF-8" %>
<%
    //request.getContextPath()루트 경로를 반환
    //response.sendRedirect(/home) 요청을 한다는것 자체가 service를 의미한다
    response.sendRedirect(request.getContextPath() + "/home");
%>
