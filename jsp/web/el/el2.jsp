<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>EL隐式对象</title>
</head>
<body>
    <%--  最常用的隐式对象pageContext(EL中调用的内置对象)  --%>
    ${pageContext}<br>
    <h5>JSP页面动态获取虚拟目录</h5>
    虚拟目录contextPath：${pageContext.request.contextPath}<br>
</body>
</html>
