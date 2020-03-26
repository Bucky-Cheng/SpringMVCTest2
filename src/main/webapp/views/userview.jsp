<%--
  Created by IntelliJ IDEA.
  User: buckycheng
  Date: 14/3/2020
  Time: 11:48 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>userview</title>
</head>
<body>
<a href="<%=request.getContextPath()%>/users/login"><h2>LogIN</h2></a>
<a href="<%=request.getContextPath()%>/users/fileupload">File Upload</a>
<h2>${userInfo.userID}</h2>
<h2>${userInfo.userName}</h2>
<h2>${userInfo.userType}</h2>
<h2>${userInfo.address}</h2>
<h2>${userInfo.tel}</h2>
<h2>${userInfo.creditMax}</h2>
<h2>${userInfo.cashDoller}</h2>
</body>
</html>
