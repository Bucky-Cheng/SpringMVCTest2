<%--
  Created by IntelliJ IDEA.
  User: buckycheng
  Date: 20/3/2020
  Time: 3:18 上午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>LogIn</title>
</head>
<body>
    <form name="LogInForm" action="<%=request.getContextPath()%>/users/logined" method="post">
        <span>UserName:</span><input type="text" id="username" name="userName" >
        <span>Pasword:</span><input type="text" id="passwordU" name="userPassword">
        <input type="submit" id="ULogIn" value="LogIn">
    </form>
</body>
</html>
