//✅ 6. Decorator Pattern (Structural Patterns)
//⭐ Simple Definition:
//Decorator adds extra features without changing the original class.
//You wrap extra features around the original object.
//Real-life example: Coffee - you can add milk and sugar. You can add milk and sugar to coffee.

package com.example.BasicToAdvance.Design_Pattern;

interface Coffee{
    String  make();
}

class SimpleCoffee implements Coffee{

    @Override
    public String make() {
       return "coffee";
    }
}

class MilkCoffee implements Coffee{
    private Coffee coffee;
    public MilkCoffee(Coffee coffee){
        this.coffee=coffee;
    }

    @Override
    public String make() {
      return  coffee.make()+" with milk";
    }
}

class SugarCoffee implements Coffee{
    private Coffee coffee;
    public SugarCoffee(Coffee coffee){
        this.coffee=coffee;
    }

    @Override
    public String make() {
        return coffee.make()+" with sugar";
    }
}
public class Decorator {

    public static void main(String[] args) {
        Coffee coffee=new SimpleCoffee();
        coffee.make();

        coffee=new MilkCoffee(coffee);
        coffee.make();

        coffee=new SugarCoffee(coffee);
        coffee.make();
    }
}
