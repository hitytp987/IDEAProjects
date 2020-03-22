package yang.web;

import yang.dao.UserDao;
import yang.domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author yang
 * @create 2020-03-23 1:09
 */
@WebServlet("/loginServlet")
public class LoginServelt extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置编码
        req.setCharacterEncoding("utf-8");
        //获取参数
        String uname = req.getParameter("uname");
        String pwd = req.getParameter("pwd");
        //封装User对象
        User loginUser = new User();
        loginUser.setName(uname);
        loginUser.setPassword(pwd);
        //调用UserDao的login方法
        UserDao userDao = new UserDao();
        User user = userDao.login(loginUser);
        if (user == null) {
            //登录失败
            req.getRequestDispatcher("/failServlet").forward(req, resp);
        } else {
            //登录成功
            //存储数据并转发
            req.setAttribute("user", user);
            req.getRequestDispatcher("/successServlet").forward(req, resp);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
