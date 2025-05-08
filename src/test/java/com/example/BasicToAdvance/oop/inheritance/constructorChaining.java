package com.example.BasicToAdvance.oop.inheritance;

class A
{
    public A()
    {
        System.out.println("Class A Constructor");
    }
}

class B extends A
{
    public B()
    {
        System.out.println("Class B Constructor");
    }
}

class C extends B
{
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
