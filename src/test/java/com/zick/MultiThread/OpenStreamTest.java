package com.zick.MultiThread;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Administrator on 2017/8/4.
 */
public class OpenStreamTest {
    public static void main(String[] args) {

        URL url = null;
        try {
            url = new URL("http://www.baidu.com");
            //通过URL的openStream 方法获取URL对象所表示的资源的字节输入流
            InputStream inputStream = url.openStream();
            //将字节输入流转换为字符输入流
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            //为字符输入流添加缓冲
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String data = bufferedReader.readLine();//读取数据
            while (data!=null){
                System.out.println(data);
                data = bufferedReader.readLine();
            }
            inputStream.close();
            inputStreamReader.close();
            bufferedReader.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
