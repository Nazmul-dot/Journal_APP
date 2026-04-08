package com.example.BasicToAdvance.oop.inheritance;

class A
{
    static{
        System.out.println("Class A Static Block");
    }
    {
        System.out.println("Class A initialization Block");
    }
    public A()
    {
        System.out.println("Class A Constructor");
    }
}

class B extends A
{
    static{
        System.out.println("Class B Static Block");
    }
    {
        System.out.println("Class B initialization Block");
    }
    public B()
    {
        System.out.println("Class B Constructor");
    }
}

class C extends B
{
    static{
        System.out.println("Class C Static Block");
    }
    {
        System.out.println("Class C initialization Block");
    }
    public C()
    {
        System.out.println("Class C Constructor");
    }
}

public class constructorChaining
{
    public static void main(String[] args)
    {

        C c = new C();
    }
}
