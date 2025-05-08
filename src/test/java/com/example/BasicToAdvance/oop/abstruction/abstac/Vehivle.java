package com.example.BasicToAdvance.oop.abstruction.abstac;

public abstract class Vehivle {

    public static final String model;
    static{
        model="bmw";
    }

    public abstract void speedup(int speed);

    public abstract int getSpeed();

    public void display(){
        System.out.println("its bmw model car");
    }
}
