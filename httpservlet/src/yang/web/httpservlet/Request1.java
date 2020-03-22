package yang.web.httpservlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author yang
 * @create 2020-03-22 21:37
 */
@WebServlet("/request1")
public class Request1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("访问了request1...");

        //获取ServletContext对象
        ServletContext servletContext = request.getServletContext();
        System.out.println("servletContext = " + servletContext);

        //共享数据只存在于一次请求操作。
        //数据共享之 存储数据
        request.setAttribute("msg","你好哈~");

        //资源转发，实现资源跳转
        //特点：1、请求转发后网址不变  2、只能转发当前服务器的内部资源中  3、转发是一次请求（只在request1请求一次）
        request.getRequestDispatcher("/request2").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //采用统一的方法进行处理get、post方法
        doPost(request,response);
    }
}
