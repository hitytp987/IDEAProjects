package web.servlet;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author yang
 * @create 2020-03-22 14:40
 *
 * Servlet方法
 */
public class ServletDemo2 implements Servlet {
    /**
     * 在Servlet被创建时执行，只会执行一次
     *
     * @param servletConfig
     * @throws ServletException
     */
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("init......");
    }

    /**
     * 获取ServletConfig对象
     * ServletConfig：Servlet的配置对象
     * @return
     */
    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    /**
     * 提供服务的方法
     * 每次被调用都会执行
     * @param servletRequest
     * @param servletResponse
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("service......");
    }

    /**
     * 获取Servelet的一些信息，作者、版本等等
     * @return
     */
    @Override
    public String getServletInfo() {
        return null;
    }

    /**
     * 在服务器正常关闭时执行，只执行一次
     */
    @Override
    public void destroy() {
        System.out.println("destroy......");
    }
}
