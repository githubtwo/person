package com.zick.MultiThread;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

/**
 * Created by Administrator on 2017/8/4.
 */
public class Client {

    public static void main(String[] args) {
        try {
            //创建客户端socket,指定服务器地址和端口
            Socket socket = new Socket("localhost",8888);
            //获取输出流，用于向服务器端发送
            OutputStream os = socket.getOutputStream();
            PrintWriter pw = new PrintWriter(os);
            pw.write("用户名：456");
            pw.flush();

            socket.shutdownOutput();

            //获取输入流，相应服务端
            InputStream is = socket.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String data= null;
            while ((data = br.readLine())!=null){
                System.out.println("我是客户端，服务端说"+data);
            }

            is.close();
            br.close();
            os.close();
            pw.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
