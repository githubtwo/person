package com.zick;

/**
 * Created by Administrator on 2017/8/9.
 */
public class Singleton {
    /**
     * 饿汉式
     */
    /*private Singleton(){}
    private static final Singleton instance = new Singleton();
    public static Singleton getInstance(){
        return instance;
    }*/

    /**
     * 懒汉式
     */
    private Singleton(){}
    private static Singleton singleton = null;
    public static Singleton getSingleton(){
        if(singleton ==null){
            singleton = new Singleton();
        }
        return singleton;
    }
}
