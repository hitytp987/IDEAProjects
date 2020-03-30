<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="yang.domain.User" %>
<%@ page import="java.util.Date" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>JSTL测试</title>
</head>
<body>
    <%
        List list = new ArrayList();
        list.add(new User("张三",20,new Date()));
        list.add(new User("李四",30,new Date(118,1,2,15,23,33)));
        list.add(new User("王五",24,new Date()));
        request.setAttribute("list",list);
    %>

    <c:forEach items="${list}" var="u">
        ${u.name} -- ${u.age} -- ${u.birthStr}<br>
    </c:forEach>
    <hr>
    <%--  将List循环展示到Table表格中  --%>
    <table border="1px" width="500px">
        <tr>
            <th>编号</th>
            <th>姓名</th>
            <th>年龄</th>
            <th>日期</th>
        </tr>
        <c:forEach items="${list}" var="u" varStatus="s">
            <c:if test="${s.count % 2 == 0}">
                <tr bgcolor="#add8e6">
            </c:if>
            <c:if test="${s.count % 2 != 0}">
                <tr bgcolor="#d3d3d3">
            </c:if>
            <td>${s.count}</td>
            <td>${u.name}</td>
            <td>${u.age}</td>
            <td>${u.birthStr}</td>
        </tr>
        </c:forEach>
    </table>

</body>
</html>
