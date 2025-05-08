package com.example.BasicToAdvance.oop.staticc;

public class CommonAll {

    public static int a=10;
    public static int b=20;

    public static final int toto=101;

    public static int sum(int a,int b){
        return a+b;
    }

    public static long sum(int [] arr){
        int len=arr.length;
        long sum= 0L;
        for (int j : arr) {
            sum += j;
        }
        return sum;
    }

}
