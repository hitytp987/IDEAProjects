<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/3/26
  Time: 21:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录页面</title>

    <script type="text/javascript">
        window.onload = function () {
            let checkCode = document.getElementById("checkCode");
            checkCode.onclick = function () {
                let time = new Date().getTime();
                checkCode.src = "/cookie_session/checkCodeServlet?"+time;
            }
        }
    </script>
    <style type="text/css">
        div{
            color: red;
        }
    </style>
</head>
<body>
<%--动态获取虚拟目录 ${pageContext.request.contextPath} --%>
<form action="${pageContext.request.contextPath}/loginServlet" method="post">
    <table>
        <tr>
            <td>用户名：</td>
            <td><input type="text" placeholder="请输入用户名" name="name"></td>
        </tr>
        <tr>
            <td>密码：</td>
            <td><input type="password" placeholder="请输入密码" name="password"></td>
        </tr>
        <tr>
            <td>验证码：</td>
            <td><input type="text" name="checkCode"></td>
        </tr>
        <tr>
            <td colspan="2"><img id="checkCode" name="checkCode" src="/cookie_session/checkCodeServlet" alt="单击刷新验证码"></td>
        </tr>
        <tr>
            <td colspan="2" align="center"><input type="submit" value="登录"></td>
        </tr>
    </table>
<%--    <div><%= request.getAttribute("code_err") == null ? "" : request.getAttribute("code_err") %></div>--%>
<%--    <div><%= request.getAttribute("user_err") == null ? "" : request.getAttribute("user_err") %></div>--%>
<%--    用EL改造上面的代码--%>
    <div>${code_err}</div>
    <div>${user_err}</div>
</form>
</body>
</html>
