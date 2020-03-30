<%@ page import="yang.domain.User" %>
<%@ page import="java.util.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java"  %><%--isELIgnored="true" 忽略整个页面的DL表达式--%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    ${3 > 4}
<%--EL表达式前加\  表示忽略单个的EL表达式--%>
    \${3 > 4}    ${3 > 4}
    <hr>
    <h3>算数运算</h3>
    +:${3 + 4}<br>
    -:${3 - 4}<br>
    *:${3 * 4}<br>
    /:${3 / 4}   ${3 div 4}<br>
    %:${3 % 4}   ${3 mod 4}<br>
    <h3>逻辑运算</h3>
    &&:${3 > 4 && 3<5}    ${3 > 2 and 3<5}
<%--`
判断字符创、数组、集合为null或者长度为0   返回true表示为null或长度为0
empty:${empty list}
--%>

<%--    EL获取值（只能从域对象中获取）  request、pageContext、session、application
        1、${域名称.键名}：从指定域中获取指定键名对应的值
            pageScop        ->  pageContext
            requestScop     ->  request
            sessionScop     ->  session
            applicationScop ->  application
        2、${键名}：从最小的域开始查找，找到为止（pageScop->requestScop->sessionScop->applicationScop）
--%>
    <h3>EL获取值</h3>
    <%
        session.setAttribute("name","李四");
        session.setAttribute("age","20");
        request.setAttribute("name","张三");
    %>
    request.name:${requestScope.name}<br>
    session.age:${sessionScope.age}<br>
    ${requestScope.haha}<br><%-- 取不到值时，返回空，不显示null   --%>
    ${name} <%--张三  返回较小域request的键名内容--%>
    <h5>EL获取对象数据</h5>
    <%
        User user = new User();
        user.setName("张三");
        user.setAge(20);
        user.setBirthday(new Date());

        request.setAttribute("u",user);

        List list = new ArrayList();
        list.add("aa");
        list.add("bb");
        list.add("cc");
        list.add(user);
        request.setAttribute("list",list);

        Map map = new HashMap<>();
        map.put("name","张三");
        map.put("gender","男");
        request.setAttribute("map",map);
        String str = "";
        request.setAttribute("str",str);

    %>
    EL获取的对象：${u}<br>
    EL获取对象的属性值：${u.name}<br>
    EL返回格式化后的日期：${u.birthStr}<br><%--此birth属性  是getBirth方法去掉get且首字母B小写后的属性--%>
    <h5>EL获取List值</h5>
    EL获取List：${list}<br>
    EL获取List的第二个元素：${list[1]}<br>
    List角标越界返回空字符串：${list[10]}<br>
    获取List中的User对象的name属性：${list[3].name}<br>
    <h5>EL获取Map值</h5>
    Map:${map}<br>
    Map.gender:${map.gender}    ${map["gender"]}
    <h5>empty 判断</h5>
    ${empty str}  <%-- 为空或者长度为0返回true --%>
    ${not empty str}  <%-- 不为空且长度>0 f返回true --%>

</body>
</html>
