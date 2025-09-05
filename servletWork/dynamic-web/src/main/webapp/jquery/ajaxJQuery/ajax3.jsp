<%--
  Created by IntelliJ IDEA.
  User: yerin
  Date: 2025-09-05
  Time: 오후 3:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
<script>
  $(function(){
    $("#btn6").click(function(){
      $.ajax({
        url: "/time",
        dataType: "text",
        success: function(data){
          console.log(data);
        },
        error: function(jqXHR, textStatus, errorThrown) {
          console.log(jqXHR.responseText);
        }
      })
    })
  });
</script>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <button id="btn6">/time</button>
    <div id="out6"></div>
</body>
</html>
