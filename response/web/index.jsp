<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/3/23
  Time: 22:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>首页</title>
  </head>
  <body>
    <a href="/response/responseDemo1">responseDemo1</a><br>
    <a href="/response/responseDemo3">字符输出流：responseDemo3</a><br>
    <a href="/response/responseDemo4">字节输出流：responseDemo4</a><br>
    <a href="/response/checkCodeServlet">验证码：checkCodeServlet</a><br>
    <a href="/response/servletContextDemo1">ServletContextDemo1</a><br>

    <hr>
<%--    <a href="/response/downloadServlet?filename=马123.jpg">下载图片</a>--%>
    <a href="/response/downloadServlet?filename=马123.jpg" >下载图片</a>
    <a href="/response/downloadServlet?filename=1.txt">下载文本</a>
  </body>
</html>
