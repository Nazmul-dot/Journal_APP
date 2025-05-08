package com.example.BasicToAdvance.oop.inheritance.exm1;

public class MainClass {

    public static void main(String[] args) {
        Car c=new Car();
        c.start();
        Vehicle v=new Vehicle();
        v.start();

        Vehicle v1=new Car();  // upcast
        v1.start();
        ((Car) v1).mode();  // downcast
    }
}
