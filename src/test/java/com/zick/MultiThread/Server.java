package com.zick.MultiThread;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Administrator on 2017/8/4.
 */
public class Server {
    public static void main(String[] args) {
        try {
            System.out.println("服务端将启动");
            ServerSocket serverSocket = new ServerSocket(8888);
            Socket socket = null;
            int count = 0;


            while (true){
                 socket = serverSocket.accept();//监听端口
                TcpServerThread serverThread = new TcpServerThread(socket);
                serverThread.start();
                count++;
                System.out.println("客户端的数量"+count);
                InetAddress inetAddress = socket.getInetAddress();
                System.out.println("当前客户端的IP:" + inetAddress.getHostAddress());
            }

            /*//获取一个输入流，用来读取客户端发送的信息
            InputStream inputStream = socket.getInputStream();
            InputStreamReader isr= new InputStreamReader(inputStream);
            BufferedReader br = new BufferedReader(isr);
            String data= null;
            while ((data = br.readLine())!=null){
                System.out.println("我是服务端，客户端说"+data);
            }
            socket.shutdownInput();//关闭输入流
            //获取输入流，相应客户端
            OutputStream os = socket.getOutputStream();
            PrintWriter pw = new PrintWriter(os);
            pw.write("欢迎您");
            pw.flush();

            pw.close();
            os.close();
            socket.close();
            br.close();
            isr.close();
            inputStream.close();*/
            //serverSocket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
