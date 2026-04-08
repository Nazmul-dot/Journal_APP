package com.example.BasicToAdvance.basicjava;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class test2 {

   public static void fun(){
        System.out.println("Hello World");

        String s="hello";
       int sum=0;
       for(int i=0;i<s.length()-1;i++){
           sum+=s.charAt(i)-s.charAt(i+1);
           System.out.println(s.charAt(i)-s.charAt(i+1));
       }

       int num[]={1,2,3,4,5,6,7,8,9,10};
//       List<Integer> list= Arrays.asList(num);
    }

    public static void main(String args[]){
        fun();
    }
}
