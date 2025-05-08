package com.example.BasicToAdvance.oop.staticc;

public class StaticImpl {
    public static void main(String[] args){
        System.out.println("a = "+CommonAll.a);
        System.out.println("b = "+CommonAll.b);
        System.out.println("toto = "+CommonAll.toto);

        int [] arr={1,2,3,4,5,6,7,8,9,10};
        long sum=CommonAll.sum(arr);
        System.out.println("sum = "+sum);
    }
}
