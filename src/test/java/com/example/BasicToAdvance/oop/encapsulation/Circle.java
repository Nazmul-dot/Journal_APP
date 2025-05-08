package com.example.BasicToAdvance.oop.encapsulation;

public class Circle {
    private double radius;
    private double area;
    private double perimeter;

    public Circle(double radius){
        this.radius=radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getArea(){
        area=Math.PI*radius*radius;
        return area;
    }

    public double getPerimeter(){
        perimeter=2*Math.PI*radius;
        return perimeter;
    }
}
