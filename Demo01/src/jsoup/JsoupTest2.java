package jsoup;

import cn.wanghaomiao.xpath.exception.XpathSyntaxErrorException;
import cn.wanghaomiao.xpath.model.JXDocument;
import cn.wanghaomiao.xpath.model.JXNode;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @author yang
 * @create 2020-03-21 21:57
 * JsoupXpath查询
 */
public class JsoupTest2 {
    public static void main(String[] args) throws IOException, XpathSyntaxErrorException {
        //1、获取Document对象，通过xml文件获取
        String path = JsoupTest2.class.getClassLoader().getResource("student.xml").getPath();
        System.out.println("path = " + path);
        Document doc = Jsoup.parse(new File(path), "utf-8");
        System.out.println("doc = " + doc);

        //2、根据Document对象，创建JXDocument对象
        JXDocument jxDocument = new JXDocument(doc);

        //3、结合Xpath语法查询
        //根据标签名查找所有user标签
        List<JXNode> jxNodes = jxDocument.selN("//user");
        for (JXNode jxNode : jxNodes) {
            System.out.println("jxNode = " + jxNode);
        }
        System.out.println("--------------");
        //查询所有user标签下的name标签
        List<JXNode> jxNodes2 = jxDocument.selN("//user/name");
        for (JXNode jxNode : jxNodes2) {
            System.out.println(jxNode);
        }
        System.out.println("--------------");
        //查询所有带id属性的user标签
        List<JXNode> jxNodes3 = jxDocument.selN("//user[@id]");
        for (JXNode jxNode : jxNodes3) {
            System.out.println(jxNode);
        }
        System.out.println("--------------");
        //查询所有带id属性的user标签,且id属性值为2
        List<JXNode> jxNodes4 = jxDocument.selN("//user[@id='2']");
        for (JXNode jxNode : jxNodes4) {
            System.out.println(jxNode);
        }


    }
}
