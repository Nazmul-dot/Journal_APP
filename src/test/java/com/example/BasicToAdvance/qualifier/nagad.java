package com.example.BasicToAdvance.qualifier;

import org.springframework.stereotype.Component;

@Component("nagad")
public class nagad implements paymentSErvice{
    @Override
    public void pay() {
        System.out.println("nagad pay");
    }
}
