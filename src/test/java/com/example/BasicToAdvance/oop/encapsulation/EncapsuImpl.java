package com.example.BasicToAdvance.oop.encapsulation;

public class EncapsuImpl {

    public static void main(String[] args){
        Student s=new Student();
        Student s1=new Student("Nazmul",18,100,"Male","Computer Science");

        System.out.println(s.getName());
        s.setName("Nazmul");
        System.out.println(s.getName());

        System.out.println(s.getAge());
        s.setAge(18);
        System.out.println(s.getAge());

        System.out.println(s.getMarks());
        s.setMarks(100);
        System.out.println(s.getMarks());

        System.out.println(s.getGender());
        s.setGender("Male");
        System.out.println(s.getGender());

        System.out.println(s.getDept());
        s.setDept("Computer Science");
        System.out.println(s.getDept());


        Products p=new Products("Computer","C1",1000);
        p.discount(20);
        System.out.println(p.getPrice());
    }
}
