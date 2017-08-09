package com.zick.MultiThread;

import org.junit.Test;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

/**
 * Created by Administrator on 2017/8/4.
 */
public class InternetTest {

    @Test
    public void test1() throws UnknownHostException {

        InetAddress inetAddress = InetAddress.getLocalHost();
        System.out.println("计算机ip地址"+inetAddress.getHostAddress());
        System.out.println("计算机名"+inetAddress.getHostName());
        byte[] bytes = inetAddress.getAddress();
        System.out.println("字节数组形式的ip " + Arrays.toString(bytes));
    }
}
