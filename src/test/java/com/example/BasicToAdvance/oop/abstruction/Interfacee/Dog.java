package com.example.BasicToAdvance.oop.abstruction.Interfacee;

public class Dog implements Animal{
    @Override
    public void makesound() {
        System.out.println("woof");
    }

    @Override
    public void eat() {
        System.out.println("eat the food");
    }

    @Override
    public void sleep() {
        System.out.println("Zzzzzz");
    }

    public void display(){
        System.out.println("dog count = "+maxAnimal);
        Animal.test();
    }


}
