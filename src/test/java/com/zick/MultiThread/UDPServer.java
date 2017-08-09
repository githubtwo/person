package com.zick.MultiThread;

import java.io.IOException;
import java.net.*;

/**
 * Created by Administrator on 2017/8/5.
 */
public class UDPServer {

    public static void main(String[] args) {

        //创建服务端，指定端口
        try {
            DatagramSocket datagramSocket = new DatagramSocket(8800);
            byte[] data = new byte[1024];//创建字节数组，指定接收的数据包的大小
            DatagramPacket packet = new DatagramPacket(data,data.length);
            int count = 0;
            System.out.println("***服务器已经启动，等待客户端发送数据**");

            while (true){
                //创建数据报，用于接收客户端发送的数据


                datagramSocket.receive(packet);//此方法在接收到数据报之前会一直阻塞
                String info = new String(data,0,packet.getLength());
                System.out.println("我是服务器，客户端说: "+info  );
                UdpServerThread udpServerThread = new UdpServerThread(datagramSocket,packet);
                udpServerThread.start();

                count++;
                System.out.println("客户端的数量"+count);
                InetAddress inetAddress = packet.getAddress();
                System.out.println("当前客户端的IP:" + inetAddress.getHostAddress());


            }
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

       /* try {
            *//**
             * 接收客户端消息
             *//*
            //创建服务端，指定端口
            DatagramSocket datagramSocket = new DatagramSocket(8800);
            //创建数据报，用于接收客户端发送的数据
            byte[] data = new byte[1024];//创建字节数组，指定接收的数据包的大小
            DatagramPacket packet = new DatagramPacket(data,data.length);
            //3.接收客户端发送的数据
            System.out.println("***服务器已经启动，等待客户端发送数据**");
            datagramSocket.receive(packet);//此方法在接收到数据报之前会一直阻塞
            //4.读取数据
            String info = new String(data,0,packet.getLength());
            System.out.println("我是服务器，客户端说: "+info  );


            *//**
             * 响应客户端
             *//*
            //1.定义客户端的地址、端口号、数据
            InetAddress address = packet.getAddress();
            int port = packet.getPort();
            byte[] data2 = "欢迎您".getBytes();
            //2.创建数据报，包含响应的数据信息
            DatagramPacket packet2 = new DatagramPacket(data2,data2.length,address,port);
            //3.响应客户端
            datagramSocket.send(packet2);
            //4.关闭资源
            datagramSocket.close();
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }*/
    }
}
