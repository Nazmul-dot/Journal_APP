package com.example.BasicToAdvance.qualifier;

import org.springframework.stereotype.Component;

@Component("bikash")
 public class bikash implements paymentSErvice
{
    @Override
    public void pay() {
        System.out.println("bikash pay");
    }
}
