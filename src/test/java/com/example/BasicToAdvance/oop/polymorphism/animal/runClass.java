package com.example.BasicToAdvance.oop.polymorphism.animal;

public class runClass {

    public static void main(String[] args){
        Animal a= new Animal();
        a.makesound();

        Animal c=new Cat();
        c.makesound();

        Animal b=new Bird();
        b.makesound();
    }
}
