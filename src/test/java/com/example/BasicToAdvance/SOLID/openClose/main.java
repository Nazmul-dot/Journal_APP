package com.example.BasicToAdvance.SOLID.openClose;


interface Shape{
       void printArea();
}

class Circle implements Shape{
    private int radius;
    public Circle(int radius){
        this.radius = radius;
    }
    @Override
    public void printArea(){
        System.out.println("Area of circle is: "+Math.PI*radius*radius);
    }
}

class Rectangle implements Shape{
    private int length;
    private int width;
    public Rectangle(int length, int width){
        this.length = length;
        this.width = width;
    }
    @Override
    public void printArea(){
        System.out.println("Area of rectangle is: "+length*width);
    }
}
class square implements Shape{
    private int side;
    public square(int side){
        this.side = side;
    }
    @Override
    public void printArea(){
        System.out.println("Area of square is: "+side*side);
    }
}


// bad
class calculateArea{
    public void printArea(Object obj){
        if(obj instanceof Circle){
            Circle circle=(Circle)obj;
             circle.printArea();
        }
        else if(obj instanceof Rectangle){
            Rectangle rectangle=(Rectangle)obj;
            rectangle.printArea();
        }
        else{
            System.out.println("Invalid object type");
        }
    }
}

//good

class calculateOCR{
    public void printArea(Shape obj){
        obj.printArea();
    }
}



public class main {

    public static void main(String[] args) {

        // bad
        Circle circle = new Circle(5);
        Rectangle rectangle = new Rectangle(5,5);
        square square = new square(5);

        calculateArea calculateArea = new calculateArea();
        calculateArea.printArea(circle);
        calculateArea.printArea(rectangle);

        System.out.println("\n");
        System.out.println("--- Following OCRP ---");
        // good

        calculateOCR calculateOCR = new calculateOCR();
        calculateOCR.printArea(circle);
        calculateOCR.printArea(rectangle);
        calculateOCR.printArea(square);



    }
}
