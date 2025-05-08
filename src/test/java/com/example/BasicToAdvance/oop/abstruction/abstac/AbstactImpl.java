package com.example.BasicToAdvance.oop.abstruction.abstac;

public class AbstactImpl {

    public static void main(String[] args){
        Car c=new Car();
        c.display();
        c.speedup(10);
        System.out.println("speed = "+c.getSpeed());

        ByCycle b=new ByCycle();
        b.display();
        b.speedup(5);
        System.out.println("speed = "+b.getSpeed());
    }
}
