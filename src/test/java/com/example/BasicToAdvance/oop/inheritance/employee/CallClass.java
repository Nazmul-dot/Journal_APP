package com.example.BasicToAdvance.oop.inheritance.employee;

public class CallClass {

    public static void main(String[] args){
        Person p=new Person("nazmul",25);
        p.dispaly();

        Employee e=new Employee("shakil",26,1000);
        e.dispaly();

        Person p2=new Employee("rofiq",23,324312);
        p2.dispaly();

        Maneger m=new Maneger("rofiq",23,324312,"it");
        m.display();

    }
}
