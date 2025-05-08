package com.example.BasicToAdvance.oop.inheritance.report;

public class Developer  extends Employee{

    private String language;

    public Developer(){

    }

    public Developer(String name,String address,double salary,String title,String language){
        super(name,address,salary,title);
        this.language=language;
    }

    public double aDouble(){
        return getSalary()*0.10;
    }

    public void report(){
        System.out.println("Performance report for Developer "+ getName()+" is good");
    }

    public void wrideCode(){
        System.out.println("write code using "+ language);
    }
}
