package yang.web.httpservlet;

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
@WebServlet("/request2")
public class Request2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("访问了request2...");

        //数据共享之  读取数据
        Object msg = request.getAttribute("msg");
        System.out.println("msg = " + msg);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //采用统一的方法进行处理get、post方法
        doPost(request,response);
    }
}
