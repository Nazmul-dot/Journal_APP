package com.example.BasicToAdvance.oop.inheritance.employee;
import lombok.*;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Person {

    private String name;
    private int age;

    public void dispaly(){
        System.out.println("name = "+name +" age = "+age);
    }
}
