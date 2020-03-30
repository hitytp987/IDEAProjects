package yang.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author yang
 * @create 2020-03-25 23:12
 * <p>
 * Cookie快速入门
 */
@WebServlet("/CookieDemo1")
public class CookieDemo1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1、创建Cookie对象
        Cookie c1 = new Cookie("msg", "Cookie消息");
        Cookie c2 = new Cookie("name", "yang");
        //设置Cookie的存活时间(在各自的浏览器)
        c1.setMaxAge(100);//正数：Cookie持久化到硬盘（关闭浏览器后再打开也有），30秒后删除。
//        c2.setMaxAge(-1);//负数（默认值）：浏览器关闭，Cookie就删除了
//        c2.setMaxAge(0);//0：删除Cookie

        //Cookie共享范围
        //1、同一个服务器下多个项目 （根据路径范围共享）
        //当前服务器存在多个项目时，默认Cookie范围是本项目内
//        c1.setPath("/cookie_session");//默认Cookie共享范围，本项目内
        c1.setPath("/");//支持同一个服务器下所有项目共享此Cookie
        //2、不同服务器下的多个项目 （根据域名domain共享）
        //设置此Cookie的域名baidu.com;那么news.baidu.com和tieba.baidu.com共享此Cookie
        c1.setDomain(".baidu.com");

        //3、发送Cookie
        response.addCookie(c1);
        response.addCookie(c2);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
