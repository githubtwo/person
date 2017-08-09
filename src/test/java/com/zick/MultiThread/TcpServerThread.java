package com.zick.MultiThread;

import java.io.*;
import java.net.Socket;

/**
 * Created by Administrator on 2017/8/4.
 */
public class TcpServerThread extends Thread {

    Socket socket = null;

    public TcpServerThread(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run() {
        super.run();
        //获取一个输入流，用来读取客户端发送的信息
        InputStream inputStream = null;
        try {
            inputStream = socket.getInputStream();
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
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {

        }

    }
}
