package com.zick;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/8/21.
 */
public class ArithMetic {
    //有一个字符串，其中包含中文字符、英文字符和数字字符，请统计和打印出各个字符的个数

    @Test
    public void characterCount(){
        String str = "中国aadf的111萨bbb菲的zz萨菲";
        int engishCount = 0;
        int chineseCount = 0;
        int digitCount = 0;

        for(int i=0;i<str.length();i++)
        {
            char ch = str.charAt(i);
            if(ch>='0' && ch<='9')
            {
                digitCount++;
            }
            else if((ch>='a' && ch<='z') || (ch>='A' && ch<='Z'))
            {
                engishCount++;
            }
            else
            {
                chineseCount++;
            }
        }

        System.out.println(engishCount);
        System.out.println(digitCount);
        System.out.println(chineseCount);

    }
    public int reverse(int x)
    {
        int result = 0;

        while (x != 0)
        {
            int tail = x % 10;
            int newResult = result * 10 + tail;
            if ((newResult - tail) / 10 != result)
            { return 0; }
            result = newResult;
            x = x / 10;
        }

        return result;
    }
    public int reverseInt(int x){
        String befor = "",after="";
        String reverse = "";
        if(x<0){
            reverse = String.valueOf(x).substring(1,String.valueOf(x).length());
        }else{
            reverse = String.valueOf(x);
        }

        if(reverse.length()%2==0) {
            for (int i = 0; i <= (reverse.length() - 1) / 2; i++) {
                befor += reverse.charAt(reverse.length() - i - 1);
                after += reverse.charAt((reverse.length() - 1) / 2 - i);
            }
        }else{
            for (int i = 0; i < (reverse.length() - 1) / 2; i++) {
                befor += reverse.charAt(reverse.length() - i - 1);
                after += reverse.charAt((reverse.length() - 1) / 2 - i);

            }
            after += reverse.charAt(0);
        }

        try {
            String result = befor+after;
            if(x<0){
                result = "-" + result;
            }
            return Integer.valueOf(result);
        }catch (NumberFormatException e ){
            return 0;
        }

    }
    public boolean isPalindrome(int x) {

        String palind = String.valueOf(x);
        if(palind.charAt(0)!=palind.charAt(palind.length()-1)){
            return false;
        }

        for(int i=0; i< palind.length()/2;i++){
            if(palind.charAt(i)!=palind.charAt(palind.length()-i-1)){
                return false;
            }
        }
        return true;
    }
    public boolean iszhishu(int x) {
        for (int i = 2; i <= x / 2; i++)
            if (x % 2 == 0)
                return false;
        return true;
    }

    // 下面的方法是求出最大公约数
    public static int gcd(int m, int n) {
        while (true) {
            if ((m = m % n) == 0)
                return n;
            if ((n = n % m) == 0)
                return m;
        }
    }
    public static void main(String[] args) {
        ArithMetic arithMetic = new ArithMetic();
        int x=111;
        System.out.println(x%10);
        System.out.println(arithMetic.reverse(x));

        System.out.println(arithMetic.isPalindrome(x));

        System.out.println("是质数吗？  "+arithMetic.iszhishu(x ));
        int a = 23;
        int b = 32;
        int c = gcd(a, b);
        System.out.println(b%a);
        System.out.println("最小公倍数：" + a * b / c + "\n最大公约数：" + c);
    }
}
