package com.zick.MultiThread;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * Created by Administrator on 2017/8/8.
 */
public class UdpServerThread extends Thread {

    DatagramSocket datagramSocket;
    DatagramPacket packet;

    public UdpServerThread(DatagramSocket datagramSocket,DatagramPacket datagramPacket){
        this.datagramSocket = datagramSocket;
        this.packet = datagramPacket;
    }

    @Override
    public void run() {
        super.run();



        //3.接收客户端发送的数据

        try {

            //4.读取数据
            byte[] data = new byte[1024];//创建字节数组，指定接收的数据包的大小
            /*String info = new String(data,0,packet.getLength());
            System.out.println("我是服务器，客户端说: "+info  );*/


            /**
             * 响应客户端
             */
            //1.定义客户端的地址、端口号、数据
            InetAddress address = packet.getAddress();
            int port = packet.getPort();
            byte[] data2 = "欢迎您".getBytes();
            //2.创建数据报，包含响应的数据信息
            DatagramPacket packet2 = new DatagramPacket(data2,data2.length,address,port);
            //3.响应客户端
            datagramSocket.send(packet2);
            //4.关闭资源
            //datagramSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
