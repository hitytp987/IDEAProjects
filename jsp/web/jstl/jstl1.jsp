<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>JSTL标签</title>
</head>
<body>
    <h3>if标签</h3>
    <%--  if标签 test是必须的，为boolean表达式，为true则展示标签内容  --%>
    <c:if test="true">
        test表达式返回true，则展示标签内容
        <br>
    </c:if>

    <%
        List list = new ArrayList();
        list.add(4);
        list.add(7);
        list.add(9);
        list.add(1);
        request.setAttribute("list",list);
    %>
    <c:if test="${not empty list}">
        list不为空
        <br>
    </c:if>
    <c:if test="${list[0] % 2 == 0}">
        list[0]的值为偶数
        <br>
    </c:if>
    <h3>choose标签</h3>
<%--
    choose      ->  switch
    when        ->  case
    otherwise   ->  default
--%>
    <%  
        //判断星期几
        request.setAttribute("number",5);
    %>
    <c:choose>
        <c:when test="${number == 1}">星期一</c:when>
        <c:when test="${number == 2}">星期二</c:when>
        <c:when test="${number == 3}">星期三</c:when>
        <c:when test="${number == 4}">星期四</c:when>
        <c:when test="${number == 5}">星期五</c:when>
        <c:when test="${number == 6}">星期六</c:when>
        <c:when test="${number == 7}">星期日</c:when>
        <c:otherwise>无效日期</c:otherwise>
    </c:choose>

    <h3>for标签</h3>
    <%--  varStatus:循环状态
            s.index：foreach循环中表示容器的索引，从0开始; 在普通for循环中就是元素值
            s.count表示循环到第几次
    --%>
    <c:forEach begin="1" end="10" var="i" step="2" varStatus="s">
        ${i} ${s.index} ${s.count}<br>
    </c:forEach>
    <hr>
    <c:forEach items="${list}" var="ele" varStatus="s">
        ${ele} -- ${s.index} -- ${s.count} <br>
    </c:forEach>

</body>
</html>
