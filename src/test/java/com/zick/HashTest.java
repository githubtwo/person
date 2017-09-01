package com.zick;

import java.util.*;

/**
 * Created by Administrator on 2017/9/1.
 */
public class HashTest {

    private int i;
    private int b;

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HashTest hashTest = (HashTest) o;

        return i == hashTest.i;

    }

    @Override
    public int hashCode() {
        return b;
    }

    public static void main(String[] args) {

        HashTest a = new HashTest();
        HashTest b = new HashTest();
        a.setI(1);
        a.setB(2);
        b.setI(2);
        b.setB(2);
        Set<HashTest> set = new HashSet<HashTest>();
        set.add(a);
        set.add(b);
        System.out.println(a.hashCode() == b.hashCode());
        System.out.println(set);
        System.out.println(a.equals(b));
    }
}
