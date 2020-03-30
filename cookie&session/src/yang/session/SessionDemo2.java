package yang.session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * @ceateinfo yang  2020-03-26 20:11
 */
@WebServlet("/sessionDemo2")
public class SessionDemo2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取Session值

        //1、获取Session对象
        HttpSession session = request.getSession();

        //默认情况下，浏览器关闭后Session就消失了，若要保存，可用Cookie存储
        Cookie cookie = new Cookie("JSESSIONID", session.getId());
        cookie.setMaxAge(60*60);//保存1小时
        response.addCookie(cookie);

        //2、获取Session值
        Object msg = session.getAttribute("msg");
        System.out.println("msg = " + msg);

        //session销毁时间
        //1、服务器关闭
        //2、Session对象调用invalidate()方法
        //3、Session默认失效时间 30分钟
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
