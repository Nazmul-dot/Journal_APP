package com.example.BasicToAdvance.oop.inheritance.report;

public class Maneger extends Employee {

    private String dept;

    public Maneger(String name,String address,double salary,String title,String dept){
        super(name,address,salary,title);
        this.dept=dept;
    }

    public void display(){
        super.report();
        System.out.println("dept = "+dept);
    }

    @Override
    public double bonuses(){
        return getSalary()*0.20;
    }

    @Override
    public void report(){
        System.out.println("Performace of the "+ getName() + "is excellent");
    }

    public void manage(){
        System.out.println("manage the project");
    }


}
