package com.example.BasicToAdvance.oop.polymorphism.vehicle;

public class Car extends Vehicle {


    @Override
    public void speedup(int speed){
        super.speedup(speed);
    }

    @Override
    public int getSpeed(){
        System.out.println("speed = "+super.getSpeed());
        return super.getSpeed();
    }
}
