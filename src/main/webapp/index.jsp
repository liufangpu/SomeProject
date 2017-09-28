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
    <script src="<c:url value="script/js/jquery.min.js"/>"></script>
    <style>
        .button {
            background-color: #4CAF50; /* Green */
            border: none;
            color: white;
            padding: 15px 32px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            font-size: 16px;
        }
    </style>
</head>

<body>
<div>
    <button class="button" id="myButton" onclick="dosome();" >点击获取当前状态</button>
</div>

<div style="width:100%;text-align:center">
<h1>Welcome</h1>

    <form action="<c:url value="/user/doswitch"/>" method="post">
        <input name="type"  type="hidden" value="isclick"/>
        用户名:<input name="username" />
         密码:<input name="password" />
        <button type="submit" >切换值</button>
    </form>
</div>
<script type="text/javascript">
    function dosome() {

        $.ajax({
            url : '<c:url value="/user/getConfig" />' ,
            type : "post",
            traditional : true,

            success : function(msg) {
                alert(msg);
            },
        });
    }
</script>
</body>

</html>
