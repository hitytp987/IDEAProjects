package yang.web.utils;

import sun.misc.BASE64Encoder;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * @author yang
 * @create 2020-03-25 20:34
 */
public class DownloadUtils {
    public static String getFileName(String agent, String fileName) throws UnsupportedEncodingException {
        if (agent.contains("MSIE")) {
            //IE浏览器
            fileName = URLEncoder.encode(fileName, "utf-8");
            fileName = fileName.replace("+", " ");
        } else if (agent.contains("Firefox")) {
            //火狐浏览器
            BASE64Encoder base64Encoder = new BASE64Encoder();
            fileName = "?utf-8?B?" + base64Encoder.encode(fileName.getBytes("utf-8")) + "?=";
        }else{
            //其他浏览器
            fileName = URLEncoder.encode(fileName,"utf-8");
        }
        return fileName;
    }
}
