<%--
  Created by IntelliJ IDEA.
  User: liufangpu
  Date: 2017-9-19
  Time: 17:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<div style="width:100%;text-align:center">
<form action="<c:url value="/user/saveInfo"/>" method="post">
    <input type="text" name="telephone" placeholder="账户名(电话号码)" size="30" /><br/><br/>

    <input type="text" name="uid" placeholder="游戏id" size="30" /><br/><br/>
    <input type="text" name="name" placeholder="姓名" size="30"/><br/><br/>
    <input type="text" name="region" placeholder="地区" size="30"/><br/><br/>
    <input type="text" name="nickname" placeholder="昵称" size="30"/><br/><br/>
    <input type="text" name="amount" placeholder="亏损金额" size="30"/><br/>
    <input type="submit" value="提交">
</form>
</div>
</body>
</html>
