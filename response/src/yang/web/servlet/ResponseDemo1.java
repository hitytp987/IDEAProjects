package yang.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author yang
 * @create 2020-03-23 22:51
 */
@WebServlet("/responseDemo1")
public class ResponseDemo1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("responseDemo1......");

        //资源重定向(重定向后网址会变为responseDemo2的)
/*      。重定向的特点
        1.地址栏发生变化
        2.重定向可以访问其他站点(服务器)的资源
        3.重定向是两次请求。不能使用request对象来共享数据

        。转发的特点:
        1.转发地址栏路径不变
        2.转发只能访问当前服务器下的资源
        3.转发是- -次请求，可以使用request对象来共享数据
        */

//        //1、设置重定向状态码 302
//        response.setStatus(302);
//        //2、设置重定向的资源地址
//        response.setHeader("location","/response/responseDemo2");
        //简单的重定向方法
        String contextPath = request.getContextPath();//虚拟目录通过参数获取，增强可移植性
        response.sendRedirect(contextPath + "/responseDemo2");
//        response.sendRedirect("http://www.baidu.com");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
