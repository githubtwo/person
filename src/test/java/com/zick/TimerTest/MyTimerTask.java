package com.zick.TimerTest;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimerTask;

/**
 * Created by Administrator on 2017/8/9.
 */
public class MyTimerTask extends TimerTask {
    private String name;

    public MyTimerTask(String inputName){
        this.name = inputName;
    }
    @Override
    public void run() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("Current exec time is " + simpleDateFormat.format(calendar.getTime()));
        System.out.println("Current exec name is " + name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
