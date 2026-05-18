package com.example.BasicToAdvance.SOLID.liskupSubs;


//🔹 L — Liskov Substitution Principle (LSP)
//-> A subclass should be replaceable with its parent class without breaking behavior.



interface Animal{
    void eate();
    void sleep();
    void moved();
}

interface RunableAnimal extends Animal {
    void run();
}

interface FlyableAnimal extends Animal {
    void fly();
}

interface SwimmableAnimal extends Animal {
    void swim();
}

class Sparrow implements FlyableAnimal {
    @Override
    public void eate() {
        System.out.println("Sparrow eating");
    }
    @Override
    public void sleep() {
        System.out.println("Sparrow sleeping");
    }
    @Override
    public void moved() {
        System.out.println("Sparrow moving");
    }
    @Override
    public void fly() {
        System.out.println("Sparrow flying");
    }
}

class Panguin implements RunableAnimal {
    @Override
    public void eate() {
        System.out.println("Panguin eating");
    }
    @Override
    public void sleep() {
        System.out.println("Panguin sleeping");
    }
    @Override
    public void moved() {
        System.out.println("Panguin moving");
    }
    @Override
    public void run() {
        System.out.println("Panguin running");
    }
}

class Crocodile implements SwimmableAnimal {
    @Override
    public void eate() {
        System.out.println("Crocodile eating");
    }
    @Override
    public void sleep() {
        System.out.println("Crocodile sleeping");
    }
    @Override
    public void moved() {
        System.out.println("Crocodile moving");
    }
    @Override
    public void swim() {
        System.out.println("Crocodile swimming");
    }
}

class Duck implements RunableAnimal, FlyableAnimal, SwimmableAnimal {
    @Override
    public void eate() {
        System.out.println("Duck eating");
    }
    @Override
    public void sleep() {
        System.out.println("Duck sleeping");
    }
    @Override
    public void moved() {
        System.out.println("Duck moving");
    }
    @Override
    public void run() {
        System.out.println("Duck running");
    }
    @Override
    public void fly() {
        System.out.println("Duck flying");
    }
    @Override
    public void swim() {
        System.out.println("Duck swimming");
    }
}

public class Main {
    public static void main(String args[]) {

    }
}