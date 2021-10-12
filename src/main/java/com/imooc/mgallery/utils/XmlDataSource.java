package com.imooc.mgallery.utils;

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
        URLDecoder decoder = new URLDecoder();
        try {
            dataFile = decoder.decode(dataFile, "UTF-8");
            System.out.println(dataFile);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        new XmlDataSource();
    }


}

