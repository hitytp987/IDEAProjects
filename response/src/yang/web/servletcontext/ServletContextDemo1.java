package yang.web.servletcontext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author yang
 * @create 2020-03-24 22:29
 */
@WebServlet("/servletContextDemo1")
public class ServletContextDemo1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置编码
        response.setContentType("text/html;charset=utf-8");

        //获取ServletContext的两种方式
        //1、通过request获取
        ServletContext servletContext1 = request.getServletContext();
        //2、通过this获取
        ServletContext servletContext2 = this.getServletContext();
        //输出得到的ServletContext信息
        System.out.println("servletContext1 = " + servletContext1);
        System.out.println("servletContext2 = " + servletContext2);
        System.out.println(servletContext1 == servletContext2);

        //定义文件名
        String file = "1.jpg";
        //获取文件对应的MIME类型
        //MIME(Multipurpose Internet Mail Extensions)多用途互联网邮件扩展类型。
        //是设定某种扩展名的文件用一种应用程序来打开的方式类型
        String mimeType = servletContext1.getMimeType(file);
        System.out.println("mimeType = " + mimeType);

        //ServletContext的作用域是访问web应用的所有用户
        servletContext1.setAttribute("msg","Demo1写入的内容");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
