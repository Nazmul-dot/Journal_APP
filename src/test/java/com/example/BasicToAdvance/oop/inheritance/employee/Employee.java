package com.example.BasicToAdvance.oop.inheritance.employee;

public class Employee extends Person {

    private double salary;

    public Employee(String name, int age, double salary) {
//        super(name, age);
        this.salary=salary;
        super.setName(name);
        super.setAge(age);
    }

    @Override
    public void dispaly(){
        System.out.println("name = "+super.getName() + " age = "+super.getAge()+" salary = "+salary);
    }
}
