package com.zick.MultiThread;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Administrator on 2017/8/4.
 */
public class UrlTest {

    public static void main(String[] args) throws MalformedURLException {

        URL imooc = new URL("http://www.imooc.com");
        URL url = new URL(imooc,"/index.html?username=tom");

        System.out.println("协议  " + url.getProtocol());
        System.out.println("主机  " + url.getHost());
        //如果未指定端口号，则使用默认的端口号，此时getPort()方法返回-1
        System.out.println("端口  " + url.getPort());
        System.out.println("查询字符串   " + url.getQuery());
        System.out.println("文件名 " + url.getFile());
        System.out.println("文件路径    " + url.getPath());
    }
}
