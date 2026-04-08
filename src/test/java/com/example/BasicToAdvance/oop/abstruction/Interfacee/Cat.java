package com.example.BasicToAdvance.oop.abstruction.Interfacee;

public class Cat implements ExtentInterface{
    @Override
    public void makesound() {
        System.out.println("meow");
    }

    @Override
    public void eat() {
        System.out.println("eat the food");
    }

    @Override
    public void sleep() {
        System.out.println("Zzzzzz");
    }
}
