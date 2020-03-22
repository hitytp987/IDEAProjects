package yang.web.httpservlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;
import java.util.Set;

/**
 * @author yang
 * @create 2020-03-22 16:38
 */
@WebServlet("/request")
public class RequestDemo extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取请求消息体--请求参数
//        BufferedReader reader = request.getReader();
//        //输出参数内容
//        String str = null;
//        while ((str = reader.readLine()) != null) {
//            System.out.println(str);
//        }
        //根据参数名称获取参数值
//        String uname = request.getParameter("uname");
//        System.out.println("uname = " + uname);
//        String pwd = request.getParameter("pwd");
//        System.out.println("pwd = " + pwd);
//        //根据参数名，获得值的数组   favs=1&favs=2&favs=3
//        String[] favs = request.getParameterValues("favs");
//        System.out.print("favs = ");
//        for (String fav : favs) {
//            System.out.print(fav);
//        }
//        System.out.println();
//        System.out.println("-----------");

        //设置流的编码，防止中文乱码
        request.setCharacterEncoding("utf-8");

        //获取所有参数的Map集合
        Map<String, String[]> map = request.getParameterMap();
        Set<String> keySet = map.keySet();
        for (String key : keySet) {
            String[] strings = map.get(key);
            System.out.print(key + "=");
            for (String string : strings) {
                System.out.print(string + "  ");
            }
            System.out.println();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //采用通用方法后，可以get和post可以用一样的方法
        doPost(request, response);

//        String method = request.getMethod();
//        System.out.println("method = " + method);
//        String contextPath = request.getContextPath();
//        System.out.println("contextPath = " + contextPath);
//        String servletPath = request.getServletPath();
//        System.out.println("servletPath = " + servletPath);
//        String requestURI = request.getRequestURI();
//        System.out.println("requestURI = " + requestURI);
//        StringBuffer requestURL = request.getRequestURL();
//        System.out.println("requestURL = " + requestURL);
//        String queryString = request.getQueryString();
//        System.out.println("queryString = " + queryString);
//        String protocol = request.getProtocol();
//        System.out.println("protocol = " + protocol);
//        String remoteAddr = request.getRemoteAddr();
//        System.out.println("remoteAddr = " + remoteAddr);
//
//        //获取请求行数据
//        //1、获取所有请求头名称
//        Enumeration<String> headerNames = request.getHeaderNames();
//        //2、遍历请求头，得等对应的值
//        while (headerNames.hasMoreElements()) {
//            String headName = headerNames.nextElement();
//            String header = request.getHeader(headName);
//            System.out.println(headName + " = " + header);
//        }

//        //获取浏览器代理 user-agent
//        String header = request.getHeader("user-agent");
//        System.out.println("user-agent = " + header);
//        //判断不同浏览器
//        if (header.contains("Chrome")) {
//            System.out.println("谷歌浏览器~~~");
//        } else if (header.contains("Firfox")) {
//            System.out.println("火狐浏览器~~~");
//        } else {
//            System.out.println("不晓得嘞~~~");
//        }
//
//        //获取请求源地址
//        String referer = request.getHeader("referer");
//        System.out.println("referer = " + referer);
//
//        if (referer != null) {
//            //防盗链
//            if (referer.contains("/httpservlet/")) {
//                response.setContentType("text/html;charset=utf-8");
//                response.getWriter().write("正常播放");
//                System.out.println("正常播放");
//            } else {
//                response.setContentType("text/html;charset=utf-8");
//                response.getWriter().write("非法链接");
//                System.out.println("非法链接");
//            }
//        }
    }
}
