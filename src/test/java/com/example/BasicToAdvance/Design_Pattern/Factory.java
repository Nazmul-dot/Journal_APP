//2. Factory Pattern(Creational Patterns)
//Definition: Creates objects without specifying the exact class to create.
//Real-life example: A vehicle factory that can produce cars, bikes, or trucks based on your order.

package com.example.BasicToAdvance.Design_Pattern;

interface Vehicle{
    void drive();
}

class Car implements Vehicle{
    @Override
    public void drive() {
        System.out.println("Car is driving");
    }
}

class Bike implements Vehicle{
    @Override
    public void drive() {
        System.out.println("Bike is driving");
    }
}

class Truck implements Vehicle{
    @Override
    public void drive() {
        System.out.println("Truck is driving");
    }
}

class VehicleFactory{
    public static Vehicle createVehicle(String type){
        if(type.equalsIgnoreCase("car")){
            return new Car();
        }
        else if(type.equalsIgnoreCase(("bike"))){
            return new Bike();
        }
        else if(type.equalsIgnoreCase("truck")){
            return new Truck();
        }
        return null;
    }
}

public class Factory {
    public static void main(String []args){
        Vehicle car=VehicleFactory.createVehicle(("car"));
        car.drive();
        Vehicle bike=VehicleFactory.createVehicle(("bike"));
        bike.drive();
        Vehicle truck=VehicleFactory.createVehicle(("truck"));
        truck.drive();
    }
}
