<%@ page contentType="text/html;charset=UTF-8" isErrorPage="true" language="java" %>

<%--
    isErrorPage：标识是否为错误页面,为true时才可以调用内置对象exception获取异常信息
--%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>服务器正忙...</h1>
    <%
        String message = exception.getMessage();
        out.print(message);
    %>
</body>
</html>
