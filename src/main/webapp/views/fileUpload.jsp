<%--
  Created by IntelliJ IDEA.
  User: buckycheng
  Date: 21/3/2020
  Time: 1:09 上午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>fileUpload</title>
</head>
<body>
<h1>File Upload</h1>
<form action="<%=request.getContextPath()%>/users/startupload" method="post" enctype="multipart/form-data">
    <input type="file" name="file">
    <input type="submit">
</form>
</body>
</html>
