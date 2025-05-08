package com.example.BasicToAdvance.oop.abstruction.abstac;

public class ByCycle extends Vehivle {

    private int speed;

    public ByCycle(){
        speed=10;
    }

    @Override
    public void speedup(int speed) {
        this.speed+=speed;
    }

    @Override
    public int getSpeed() {
        return 0;
    }

    public void display(){
        System.out.println("model of the cycle = "+model);
        System.out.println("speed = "+speed);
    }
}
