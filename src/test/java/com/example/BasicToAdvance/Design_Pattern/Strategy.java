//4. Strategy Pattern(Behavioral Patterns)
//Definition: Defines a family of algorithms and makes them interchangeable
//Real-life example: Different payment methods (credit card, PayPal, cash) - you choose one at checkout.


package com.example.BasicToAdvance.Design_Pattern;

interface Payment{
    void pay(int amount);
}

class CreditCard implements Payment{
    private int creditCardNumber;

    public CreditCard(int creditCardNumber){
        this.creditCardNumber=creditCardNumber;
    }

    @Override
    public void pay(int amount) {
        System.out.println("Paid $"+amount+" using credit card number "+creditCardNumber);
    }
}

class Paypal implements Payment{
    private String paypalEmail;

    public Paypal(String paypalEmail){
        this.paypalEmail=paypalEmail;
    }

    @Override
    public void pay(int amount) {
        System.out.println("Paid $"+amount+" using Paypal email "+paypalEmail);
    }
}

class CashPayment implements Payment{
    private int amount;

  public CashPayment(int amount){
      this.amount=amount;
  }

    @Override
    public void pay(int amount) {
        System.out.println("Paid $"+amount+" using cash");
    }
}

class ShoppingCart{
    private Payment payment;
    public ShoppingCart(Payment payment){
        this.payment=payment;
    }
    public void bill(int amount){
        payment.pay(amount);
    }
}

public class Strategy {

    public static void main(String[] args) {
       ShoppingCart cart;

       cart=new ShoppingCart(new CreditCard(123456789));
       cart.bill(100);

       cart=new ShoppingCart(new Paypal("paypal@email.com"));
       cart.bill(200);

       cart=new ShoppingCart(new CashPayment(300));
       cart.bill(300);
    }
}
