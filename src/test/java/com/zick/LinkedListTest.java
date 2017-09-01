package com.zick;

import com.google.common.collect.Lists;

import java.util.*;

/**
 * Created by Administrator on 2017/9/1.
 */
public class LinkedListTest {

    LinkedList linkedList;
    Vector vector;
    List list;
    Stack stack;
    ArrayList arrayList = Lists.newArrayList();

    public static void main(String[] args) {
        LinkedList<String> lList = new LinkedList<String>();
        lList.add("1");
        lList.add("2");
        lList.add("3");
        lList.add("4");
        lList.add("5");


        System.out.println("链表的第一个元素是 : " + lList.getFirst());
        System.out.println("链表最后一个元素是 : " + lList.getLast());
    }
}
