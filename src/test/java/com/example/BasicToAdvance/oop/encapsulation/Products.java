package com.example.BasicToAdvance.oop.encapsulation;

public class Products {

    private String name;
    private String code;
    private double price;

    private Products(){

    }

    public Products(String name,String code,double price){
        this.name=name;
        this.code=code;
        this.price=price;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }

    public void discount(double discount){
        if(discount>0 && discount<100){
            this.price-=this.price*(discount/100);
        }
    }
}
