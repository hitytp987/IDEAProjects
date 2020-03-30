package yang.web.servletcontext;

import yang.web.utils.DownloadUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * @author yang
 * @create 2020-03-24 23:38
 */
@WebServlet("/downloadServlet")
public class DownloadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //1、获取文件名参数
        String filename = request.getParameter("filename");
        //2、获取服务器路径
        ServletContext servletContext = this.getServletContext();
        String realPath = servletContext.getRealPath("/file/" + filename);

        try {
            //3、得到完整的文件路径，并读入内存
//            BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(
//                    new File(realPath)));
            InputStream inputStream = this.getServletContext().getResourceAsStream(realPath);

            //响应设置
            //4、设置响应头类型
            String mimeType = servletContext.getMimeType(filename);
            response.setHeader("content-type", mimeType); //设置文件的MIME类型
            //5、对响应方式content-disposition进行设置（附件形式）
            String agent = request.getHeader("user-agent");
            filename = DownloadUtils.getFileName(agent, filename);
            response.setHeader("content-disposition", "attachment;filename=" + filename);
            //5、返回输出流
            byte[] bytes = new byte[1024 * 10];
            int len = 0;
            while ((len = inputStream.read(bytes)) != -1) {
                response.getOutputStream().write(bytes, 0, len);
            }
            inputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
