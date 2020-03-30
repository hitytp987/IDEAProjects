<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" errorPage="500.jsp" language="java" %>
<%@ include file="top.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--
    page标签：
        import：自动导包
        errorPage：页面发生错误时，自动跳转到500.jsp
        isErrorPage：标识是否为错误页面,为true时才可以调用内置对象exception获取异常信息
    include标签：
        file：导入的文件
     taglib标签：
        prefix：约定俗成用前缀“c”表示JSTL标签
        uri：导入资源
--%>

<html>
  <head>
    <title>JSP学习</title>
  </head>
  <body>

<%--    9个内置对象
    3.内置对象
*在jsp页面中不需要创建，直接使用的对象
一共有9个 :
变量名         真实类型            作用
pageContext     PageContext         当前页面共享数据，还可以获取其他8个内置对象
request         HttpServletRequest  一次请求访问的多个资源（转发实现共享）
session         HttpSession         一个会话的多个请求
application     ServletContext      所有用户共享数据

response        HttpServletResponse 响应对象
page            object              当前页面（Servlet）对象 this
out             JspWriter           输出对象，数据输出到页面上
config          ServletConfig       Servlet的配置对象
exception       Throwable           异常对象
--%>

    <%
        pageContext.setAttribute("pageContext","pageContext在当前页面共享数据");
        //可以获取其他8个对象，get方法获取
        //pageContext.getRequest();
    %>

    <%= pageContext.getAttribute("pageContext") %>


      <!--
        <h3>只能注释html代码片段</h3>
      -->

      <%--
      <%
          System.out.println("能注释所有");
      %>
      --%>
      <%
          List list = new ArrayList<>();
//          int i = 3/0;
      %>
  </body>
</html>
