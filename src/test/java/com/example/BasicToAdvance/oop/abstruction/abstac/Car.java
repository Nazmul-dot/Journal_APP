package com.example.BasicToAdvance.oop.abstruction.abstac;

public class Car extends Vehivle {

    private int speed;

    public Car(){
        speed=10;
    }

    @Override
    public void speedup(int speed) {
        this.speed+=speed;
    }

    @Override
    public int getSpeed() {
        return speed;
    }

    public void display(){
        System.out.println("model of the car = "+model);
        System.out.println("speed = "+speed);
    }
}
