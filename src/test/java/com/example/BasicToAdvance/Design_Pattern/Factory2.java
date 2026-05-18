package com.example.BasicToAdvance.Design_Pattern;

import java.util.HashMap;
import java.util.Map;

interface PaymentOnline{
    public void pay(double amount);
}

class BkashOnline implements  PaymentOnline{
    @Override
    public void pay(double amount){
        System.out.println(amount+" tk Bkash Online Payment done");
    }
}

class NagadOnline implements PaymentOnline{
    @Override
    public void pay(double amount){
        System.out.println(amount+" tk Nagad Online Payment done");
    }
}

class UpiOnline implements PaymentOnline{
    @Override
    public void pay(double amount){
        System.out.println(amount+" tk Upi Online Payment done");
    }
}

class PaymentFactory{
    public static PaymentOnline payBill(String type){
        if(type.equals("Bkash")){
            return new BkashOnline();
        }
        else if(type.equals("Nagad")){
            return new NagadOnline();
        }
        else if(type.equals("Upi")){
            return new UpiOnline();
        }
        else{
            throw new IllegalArgumentException("Invalid payment type: " + type);
        }
    }
}

class PaymentFactory2{
    private static final Map<String,PaymentOnline> paymentFactoryMap=new HashMap<>();
    static{
        paymentFactoryMap.put("bkash",new BkashOnline());
        paymentFactoryMap.put("nagad",new NagadOnline());
        paymentFactoryMap.put("upi",new UpiOnline());
    }

    public static PaymentOnline payBill(String type){
           PaymentOnline payment=paymentFactoryMap.get(type.toLowerCase());
           if(payment==null){
               throw new IllegalArgumentException("Invalid payment type: " + type);
           }
           return payment;
    }
}

public class Factory2 {
    public static void main(String []args){
        System.out.println("Hello World");
        PaymentOnline payment=PaymentFactory.payBill("Bkash");
        payment.pay(10);
        payment=PaymentFactory.payBill("Nagad");
        payment.pay(20);
        payment=PaymentFactory.payBill("Upi");
        payment.pay(30);

        System.out.println("--------------------------------------------------------------------------------");
        PaymentOnline payment2=PaymentFactory2.payBill("Bkash");
        payment2.pay(40);
        payment2=PaymentFactory2.payBill("Nagad");
        payment2.pay(50);
        payment2=PaymentFactory2.payBill("Upi");
        payment2.pay(60);
    }
}
