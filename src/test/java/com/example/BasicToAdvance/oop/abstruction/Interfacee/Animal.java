package com.example.BasicToAdvance.oop.abstruction.Interfacee;

public interface Animal {


     void makesound();

     void eat();

     void sleep();

      int maxAnimal=5;
      int x=10;

     default void display(){
         System.out.println("animal count = "+maxAnimal);
     }

     public static void test(){
         System.out.println("test");
     }



}
