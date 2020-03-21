package jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * @author yang
 * @create 2020-03-21 21:57
 * Jsoup快速入门
 */
public class JsoupTest1 {
    public static void main(String[] args) throws IOException {
        //1、获取Document对象，通过xml文件获取
        String path = JsoupTest1.class.getClassLoader().getResource("student.xml").getPath();
        System.out.println("path = " + path);
        Document doc = Jsoup.parse(new File(path), "utf-8");
        System.out.println("doc = " + doc);
        //通过url获取document对象
//        URL url = new URL("https://www.baidu.com/");//获取网络对象
//        Document doc = Jsoup.parse(url, 10000);
//        System.out.println("document = " + doc);

        //2、获取元素对象
        Elements names = doc.getElementsByTag("name");
        System.out.println(names.size());
        //3、展示获取到的元素值
        for (Element name : names) {
            System.out.println("name = " + name.text());
        }

        String attr = doc.getElementsByTag("user").get(1).attr("id");
        System.out.println("attr = " + attr);


    }
}
