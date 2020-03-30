package yang.servlet;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

/**
 * @author yang
 * @create 2020-03-24 0:15
 */
@WebServlet("/checkCodeServlet")
public class CheckCodeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //验证码  宽、高
        int height = 50;
        int width = 250;

        //创建一个对象，在内存中的图片（验证码图片对象）
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        //美化图片
        //1、填充背景色
        Graphics graphics = image.getGraphics();//获取画笔对象
        graphics.setColor(Color.PINK);//画笔颜色
        graphics.fillRect(0, 0, width, height);//画出矩形区域
        //2、画边框
        graphics.setColor(Color.BLUE);
        graphics.drawRect(0, 0, width - 1, height - 1);//画矩形边框

        String str = "QWERTYUIOPLKJHGFDSAZXCVBNMqwertyuioplkjhgfdsazxcvbnm0123456789";
        //3、生成随机
        Random ran = new Random();
        StringBuilder checkCode = new StringBuilder();
        //生成随机数
        for (int i = 1; i <= 4; i++) {
            int index = ran.nextInt(str.length());
            char val = str.charAt(index);
            graphics.drawString(val + "", width / 5 * i, height / 2);
            checkCode.append(val); //记录图片展示的验证码
        }
        //画干扰线
        graphics.setColor(Color.GREEN);
        for (int i = 0; i < 8; i++) {
            int x1 = ran.nextInt(width);
            int x2 = ran.nextInt(width);
            int y1 = ran.nextInt(height);
            int y2 = ran.nextInt(height);
            graphics.drawLine(x1, y1, x2, y2);
        }

        //在浏览器展示图片
        ImageIO.write(image, "jpg", response.getOutputStream());

        //设置session存储验证码
        HttpSession session = request.getSession();
        session.setAttribute("checkCode", checkCode.toString());//保存验证码
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
