package com.example.BasicToAdvance.SOLID.InterfaceSeg;

interface Workable {
    void work();
}

interface Eatable {
    void eat();
}

interface Codable {
    void code();
}

class Programmer implements Workable, Eatable, Codable {
    public void work() { System.out.println("Programming work"); }
    public void eat() { System.out.println("Eating while coding"); }
    public void code() { System.out.println("Writing code"); }
}

class Manager implements Workable, Eatable {
    public void work() { System.out.println("Managing team"); }
    public void eat() { System.out.println("Business lunch"); }
    // Doesn't need to implement Codable
}

class Robot implements Workable {
    public void work() { System.out.println("Working 24/7"); }
    // Doesn't need Eatable or Codable
}

public class main {
}
