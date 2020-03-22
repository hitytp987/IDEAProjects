package yang.web;

import yang.domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author yang
 * @create 2020-03-23 1:26
 */
@WebServlet("/successServlet")
public class SuccessServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //显示登录成功的结果

        //设置字符
        response.setContentType("text/html;charset=utf-8");
        //显示登录人员信息
        User user = (User) request.getAttribute("user");
        if (user != null) {
            response.getWriter().write("登录成功!" + user.getName() + "，欢迎回来！");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
