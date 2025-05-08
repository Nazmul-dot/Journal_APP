package com.example.BasicToAdvance.oop.polymorphism.vehicle;

public class runClass {
    public static void main(String[] args){
        Vehicle v=new Car();
        v.speedup(30);
        System.out.println("speed = "+v.getSpeed());

        Vehicle v1=new ByCycle();
        v1.speedup(10);
        System.out.println("speed = "+v1.getSpeed());
    }
}
