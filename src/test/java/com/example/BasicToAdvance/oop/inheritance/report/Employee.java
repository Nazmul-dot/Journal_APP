package com.example.BasicToAdvance.oop.inheritance.report;

public class Employee {

    private String name;
    private String address;
    private double salary;
    private String title;

    public Employee(){

    }

    public Employee(String name,String address,double salary,String title){
        this.name=name;
        this.address=address;
        this.salary=salary;
        this.title=title;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public double getSalary() {
        return salary;
    }

    public String getTitle() {
        return title;
    }

    public double bonuses(){
        return 0.0;
    }

    public void report(){
        System.out.println("name = "+name+" address = "+address+" salary = "+salary+" title = "+title);
    }
}
