<%@ page contentType="text/html;charset=UTF-8" %>
<%
    session.removeAttribute("cart");
    response.sendRedirect("productList.jsp");
%>
