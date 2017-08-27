package com.zick;

import java.util.Arrays;

/**
 * Created by Zick on 2017/8/26.
 */
public class QuickSort{

        public void quickSort(String[] strDate,int left,int right){
            String middle,tempDate;
            int i,j;
            i=left;
            j=right;
            middle=strDate[(i+j)/2];
            do{
                while(strDate[i].compareTo(middle)<0&& i<right)
                    i++; //找出左边比中间值大的数
                while(strDate[j].compareTo(middle)>0&& j>left)
                    j--; //找出右边比中间值小的数
                if(i<=j){ //将左边大的数和右边小的数进行替换
                    tempDate=strDate[i];
                    strDate[i]=strDate[j];
                    strDate[j]=tempDate;
                    i++;
                    j--;
                }
            }while(i<=j); //当两者交错时停止
            if(i<right){
                quickSort(strDate,i,right);//从
            }
            if(j>left){
                quickSort(strDate,left,j);
            }
        }

        public void BubbleSort(int[] arg){

            int temp;
            for(int i=arg.length-1;i>0;i--){
                for(int j=0;j<i;j++){
                    if(arg[j] > arg[j+1]){
                        temp = arg[j];
                        arg[j] = arg[j+1];
                        arg[j+1]=temp;
                    }
                }
            }
        }

         public int[] twoSum(int[] nums, int target) {
            int[] a = new int[2];
            for(int i=0;i<nums.length;i++){
                for(int j=i+1;j<nums.length;j++){
                    if((nums[i] + nums[j]) == target){
                        a[0]=i;
                        a[1]=j;
                        return a;
                    }
                }
            }
            return null;
        }

        public int[] addTwo(int[] a,int[] b){
            int[] c=new int[a.length + b.length];
            int k=0,j=0;
            boolean done=false;
            for(int i=0;i<a.length;i++){
                for(;j<b.length;j++){

                    if(a[i]>b[j]){
                        c[k++]=b[j];
                    }else{
                        if(done){
                            c[k++]=b[j];
                        }
                        else{
                            c[k++]=a[i];
                            if((i+1)==a.length){
                                j--;
                                done=true;
                            }else {
                                break;
                            }
                        }

                    }

                }
            }
            return c;
        }


        /**
         * @param args
        牛客网-程序员笔试面试题库，程序员求职备考网站 http://w w w .now coder.com
         */
        public static void main(String[] args) {
            String[] strVoid = new String[]{
                "11", "66", "22", "0", "55", "22", "0", "32"
            };
            QuickSort sort = new QuickSort();
     /*       sort.quickSort(strVoid, 0, strVoid.length - 1);
            *//*for (int i = 0; i < strVoid.length; i++) {
                System.out.println(strVoid[i] + " ");
            }*//*
            System.out.println(Arrays.toString(strVoid));

            int[] a = new  int[]{1,8,9,4,0,20,10};
            int[] b= new int[]{3,2,4};
            System.out.println(Arrays.toString(sort.twoSum(b,6)));
            sort.BubbleSort(a);
            System.out.println(Arrays.toString(a));*/

            int[] c=new int[]{1,3,4};
            int[] d=new int[]{2,5};
            System.out.println(Arrays.toString(sort.addTwo(c,d)));
        }
}
