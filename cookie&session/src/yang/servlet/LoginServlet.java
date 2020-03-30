package yang.servlet;

import org.apache.commons.beanutils.BeanUtils;
import yang.dao.UserDao;
import yang.domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * @ceateinfo yang  2020-03-26 21:46
 */
@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置编码
        request.setCharacterEncoding("utf-8");

        //获取图片验证码
        HttpSession session = request.getSession();
        String cc = (String) session.getAttribute("checkCode");
        //获取完验证码后，立马删除验证码，避免重复使用
        session.removeAttribute("checkCode");

        //获取参数值
        Map<String, String[]> map = request.getParameterMap();
        System.out.println("验证码：" + map.get("checkCode")[0]);//打印验证码

        if (map.get("checkCode")[0].equalsIgnoreCase(cc)) {//忽略大小写
            //验证码一致，判断用户信息
            User loginUser = new User();
            try {
                BeanUtils.populate(loginUser, map);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
            //验证登录信息
            UserDao userDao = new UserDao();
            User user = userDao.login(loginUser);
            if (user == null) {
                //用户信息错误，返回登录界面
                request.setAttribute("user_err", "用户名或密码错误");
                request.getRequestDispatcher("/login.jsp").forward(request, response);
            } else {
                //登录成功
                request.getSession().setAttribute("User", user);
                response.sendRedirect(request.getContextPath() + "/successServlet");
            }

        } else {
            //验证码不一致，返回登录界面
            request.setAttribute("code_err", "验证码错误");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
