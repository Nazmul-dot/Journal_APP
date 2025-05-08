package com.example.BasicToAdvance.oop.inheritance.employee;

public class Maneger extends Employee{
    private String dept;

    public Maneger(String name,int age,double salary,String dept){
        super(name,age,salary);
        this.dept=dept;
    }

    public void display(){

        super.dispaly();
        System.out.println("dept = "+dept);
    }
}
