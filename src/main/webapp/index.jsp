<%--
  Created by IntelliJ IDEA.
  User: liufangpu
  Date: 2017-9-19
  Time: 17:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Title</title>
    <script src="<%=basePath%>script/js/jquery.min.js"></script>
</head>

<body>

<div style="width:100%;text-align:center">
<h1>Welcome</h1>
    <div>

        获取当前状态 <button id="myButton" onclick="dosome();"></button>
        <input name="value" id="config">
    </div>
    <form action="<c:url value="/user/doswitch"/>" method="post">
        <input name="type"  type="hidden" value="isclick"/>
        用户名:<input name="username" />
         密码:<input name="password" />
        <button type="submit" >切换值</button>
    </form>
</div>
<script type="text/javascript">
    $(document).ready(function() {
        var value=document.getElementById("myButton");
        $.ajax({
            url : '<c:url value="/user/getConfig" />' ,
            type : "post",
            traditional : true,

            success : function(msg) {

                value=msg;
            },
        });
    });

    function dosome() {

        var value=document.getElementById("config");
        $.ajax({
            url : '<c:url value="/user/getConfig" />' ,
            type : "post",
            traditional : true,

            success : function(msg) {
                document.getElementById("config").innerText=msg;
            },
        });
    }
</script>
</body>

</html>
