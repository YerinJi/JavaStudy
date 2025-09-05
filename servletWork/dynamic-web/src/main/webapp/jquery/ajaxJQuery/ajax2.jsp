
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Bootstrap Example</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
    <h2>Striped Rows</h2>
    <div class="container">
    <p>The .table-striped class adds zebra-stripes to a table:</p>
    <table class="table table-striped">
        <thead id="thead">

        </thead>
        <tbody id="tbody">

        </tbody>
    </table>
</div>
</body>

<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
<script>
    function ajaxProcess(url, method,dataType){
        $.ajax({
            url: url,
            method: method,
            dataType: dataType,
            success: function(data){ //Ajax통신이 성공했을 때
                // console.log(data.no+" "+data.name +" "+data.age);
                // console.log(data["no"]+" "+data["name"] +" "+data["age"]);
                // console.log(data);
                $("#thead").html("");
                $("#thead").append("<tr>");
                for(var key in data){
                    for(var j in data[key]){
                        // console.log(j);
                        $("#thead").append("<td>" +j+ "</td>");
                    }
                    break;
                }
                $("#thead").append("</tr>");


                $.each(data, function(key,val){
                    // console.log(key+" "+val);
                    $("#tbody").append("<tr>");
                    for(var i in val){
                        // console.log(val[i]);
                        $("#tbody").append("<td>" + val[i] + "</td>");
                    }
                    $("#tbody").append("</tr>");
                })


                // $.each(data, function(key, value){
                //     console.log(key, value);
                //     for(var i in value){
                //         console.log(value[i]);
                //     }
                // })

            },
            error: function(data){ //Ajax통신이 실패했을 때
                console.log(data);
            }
        })
    }
    $(function() {
        $("[class='container]").hide();
        $("h2").on("click", function() {
            ajaxProcess('userInfo.jsp','GET','json')
            // $("[class='container']").show().slideDown(1000).slideUp(1000).slideDown(1000);
        })
    })
</script>
</html>
