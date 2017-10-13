<%--
  Created by IntelliJ IDEA.
  User: liufangpu
  Date: 2017-10-13
  Time: 15:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>用户信息</title>
</head>
<script src="<c:url value="/script/js/jquery.min.js"/>"></script>
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
<body>
<div>
    <button class="button" id="myButton" onclick="dosome();" >点击获取当前状态</button>
</div>
<br/>
<div>
    <button class="button" id="doswitch" onclick="doswitch();" >切换状态</button>
</div>
<div style="width:100%;text-align:center">
<table border="1">
    <tr>
        <td>hh_id</td>
        <td>注册地ip</td>
        <td>调用次数</td>
    </tr>
    <c:forEach items="${userinfo}" var="user">
        <tr>
            <td>${user.hhId}</td>
            <td>${user.ip}</td>
            <td>${user.accessTimes}</td>
        </tr>
    </c:forEach>


</table>
</div>
<div style="width:100%;text-align:center">
    <table border="1">
        <tr>

            <td>hh_id</td>
            <td>people_id</td>
            <td>phone_version</td>
            <td>phone_model</td>
        </tr>
        <c:forEach items="${deviceinfo}" var="device">
            <tr>
                <td>${device.hhId}</td>
                <td>${device.peopleId}</td>
                <td>${device.phoneVersion}</td>
                <td>${device.phoneModel}</td>
            </tr>
        </c:forEach>


    </table>
</div>
<script type="text/javascript">
    function doswitch() {

        $.ajax({
            url : '<c:url value="/user/doswitch" />' ,
            type : "post",
            traditional : true,

            success : function(msg) {
                alert(msg);
            },
        });
    }


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
