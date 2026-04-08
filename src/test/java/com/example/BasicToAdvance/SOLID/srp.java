package com.example.BasicToAdvance.SOLID;


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
class square implements Shape{
    private int side;
    public square(int side){
        this.side=side;
    }
    @Override
    public void printArea(){
        System.out.println("Area of square is: "+side*side);
    }
}

class calculateArea{
    public void printArea(Object obj){
        if( obj instanceof Circle){
            ((Circle) obj).printArea();
        }
        else if(obj instanceof square){
            ((square) obj).printArea();
        }
        else{
            System.out.println("Invalid object type");
        }
    }
}

class calculateOCR{
    public void printArea(Shape obj){
        obj.printArea();
    }
}

public class srp {
    public static void main(String[] args){

    }
}
