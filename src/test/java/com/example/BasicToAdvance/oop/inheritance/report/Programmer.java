package com.example.BasicToAdvance.oop.inheritance.report;

public class Programmer extends Developer{


    public Programmer(){

    }
    public Programmer(String name,String address,double salary,String title,String language){
        super(name,address,salary,title,language);
    }

    @Override
    public double bonuses(){
        return super.getSalary()*0.20;
    }

    @Override
    public void report(){
        System.out.println("Performance report for Programmer "+ getName()+" is good");
    }

    public void debug(){
        System.out.println("debug the code");
    }


}
