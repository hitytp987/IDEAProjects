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
 * @create 2020-03-24 23:11
 */
@WebServlet("/servletContextDemo3")
public class ServletContextDemo3 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext servletContext = this.getServletContext();
        //获取文件的服务器路径
        String realPathB = servletContext.getRealPath("/b.txt");//web目录下资源访问
        String realPathC = servletContext.getRealPath("/WEB-INFO/c.txt");//WEB-INFO目录下资源访问
        String realPathA = servletContext.getRealPath("/WEB-INFO/classes/a.txt");//src目录下资源访问
        System.out.println("web目录下realPathB = " + realPathB);
        System.out.println("WEB-INFO目录下realPathC = " + realPathC);
        System.out.println("src目录下realPathC = " + realPathA);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
