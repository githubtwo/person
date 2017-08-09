package com.zick.TimerTest;

import java.util.Timer;

/**
 * Created by Administrator on 2017/8/9.
 */
public class MyTimer {
    public static void main(String[] args) {
        Timer timer = new Timer();
        MyTimerTask myTimerTask = new MyTimerTask("No.1");
        //通过timer定时频率调用myTimerTask的业务逻辑
        //即第一次执行是在当前时间的两秒之后，之后每隔一秒执行
        timer.schedule(myTimerTask,2000,1000);
    }
}
