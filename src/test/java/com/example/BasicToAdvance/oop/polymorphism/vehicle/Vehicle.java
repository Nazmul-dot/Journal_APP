package com.example.BasicToAdvance.oop.polymorphism.vehicle;

public class Vehicle {
    private int speed;

    public Vehicle(){
        speed=20;
    }

    public void speedup(int speed){
        this.speed+=speed;
    }

    public int getSpeed(){
        return speed;
    }
}
