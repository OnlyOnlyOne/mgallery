package com.imooc.mgallery.utils;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

//数据源类，用于将XML文件解析为Java对象。
public class XmlDataSource {
    //通过static静态关键字保证数据全局唯一，
    private static List data = new ArrayList();
    private static String dataFile;

    //对静态对象进行初始化，要用static块
    static {
        //使用dom4j对xml文件进行读写
        dataFile = XmlDataSource.class.getResource("/painting.xml").getPath();
        System.out.println(dataFile);
        URLDecoder decoder = new URLDecoder();//如果获取的路径有空格，读取到的后会有%20，所以需要用这个类去转换格式
        try {
            dataFile = decoder.decode(dataFile, "UTF-8");
            System.out.println(dataFile);
            //利用Dom4j对XML进行解析
            SAXReader saxReader = new SAXReader();
            //1.获取Document文档对象
            Document document = saxReader.read(dataFile);
            //2.Xpath获取XML结点
            List<Node> nodes = document.selectNodes("/root/painting");
            for (Node node : nodes
            ) {
                Element element = (Element) node;
                String id = element.attributeValue("id");
                String pname = element.elementText("pname");
                System.out.println(id + ":" + pname);

            }
        } catch (UnsupportedEncodingException | DocumentException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        new XmlDataSource();
    }


}

