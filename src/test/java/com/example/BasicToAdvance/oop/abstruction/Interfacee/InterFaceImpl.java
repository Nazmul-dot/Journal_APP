package com.example.BasicToAdvance.oop.abstruction.Interfacee;

public class InterFaceImpl {

     public static void main(String[] args){
         Animal a=new Dog();
         a.makesound();
         a.eat();
         a.sleep();
         a.display();
         Animal.test();
         System.out.println("---------------------------------------------");
         ExtentInterface t=new Cat();
         t.makesound();
         t.eat();
         t.sleep();
     }
}
