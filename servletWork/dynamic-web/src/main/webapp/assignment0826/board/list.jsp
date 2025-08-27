<%--
  Created by IntelliJ IDEA.
  User: yerin
  Date: 2025-08-27
  Time: 오전 9:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ include file="../common/top.jsp" %>
<div class="container mt-3">
    <h2>시간표</h2>
    <table class="table">
        <thead>
        <tr>
            <th>시간</th>
            <th>할일</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>7:30 - 8:00</td>
            <td>기상</td>
        </tr>
        <tr>
            <td>8:00-9:00</td>
            <td>수업준비</td>
        </tr>
        <tr>
            <td>9:00-9:50</td>
            <td>SQL</td>
        </tr>
        <tr>
            <td>10:00-10:50</td>
            <td>HTML & CSS</td>
        </tr>
        <tr>
            <td>11:00-11:50</td>
            <td>Servlet</td>
        </tr>
        <tr>
            <td>12:00-13:00</td>
            <td>점심</td>
        </tr>
        <tr>
            <td>13:00-14:00</td>
            <td>JSP</td>
        </tr>
        <tr>
            <td>14:00-14:50</td>
            <td>JAVA</td>
        </tr>
        </tbody>
    </table>
</div>

<jsp:include page="../common/bottom.jsp"/>
