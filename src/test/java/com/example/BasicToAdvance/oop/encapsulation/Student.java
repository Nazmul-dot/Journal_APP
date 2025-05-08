package com.example.BasicToAdvance.oop.encapsulation;

public class Student {

    private String name;
    private int age;
    private double marks;
    private String gender;
    private String dept;
    private static final String section = "A";

    public Student(){
        name="Nazmul";
        age=18;
        marks=100;
        gender="Male";
        dept="Computer Science";
    }
    public Student(String name,int age,double markd,String gender,String dept){
        this.name=name;
        this.age=age;
        this.marks=markd;
        this.gender=gender;
        this.dept=dept;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if(age<18){
            age=18;
        }
        this.age = age;
    }

    public double getMarks() {
        return marks;
    }

    public void setMarks(double marks) {
        this.marks = marks;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getmarks(){
        String str=String.format("marks =%g",marks);
        return str;
    }

    public String getmarkfloat(){
        String str=String.format("marks = %f",marks);
        String str2=String.format("marks = %.2f",marks);
        return str;
    }
}
