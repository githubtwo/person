package com.zick.MultiThread;

import java.io.IOException;
import java.net.*;

/**
 * Created by Administrator on 2017/8/5.
 */
public class UDPClient {
    public static void main(String[] args) throws IOException {

        /**
         * 向服务器端发送数据
         */
        //1.定义服务器地址，端口、数据
        InetAddress address = InetAddress.getByName("localhost");
        int port = 8800;
        byte[] data = "用户名：admin,密码：123".getBytes();
        //2.创建数据报，包含发送的数据信息
        DatagramPacket packet = new DatagramPacket(data,data.length,address,port);
        //3.创建DatagramSocket对象
        DatagramSocket socket = new DatagramSocket();
        //4.想服务器端发送数据包
        socket.send(packet);


        /**
         * 接收服务端的数据
         */
        //1.创建数据报，用于接收数据
        byte[] data2 = new byte[1024];
        DatagramPacket packet1 = new DatagramPacket(data2,data.length);
        //2.接收服务器端响应的数据
        socket.receive(packet1);
        //3.读取数据
        String reply = new String(data2,0,packet1.getLength());
        System.out.println("我是客户端，服务器端说: " + reply);
        //4.关闭资源
        socket.close();
    }

}
