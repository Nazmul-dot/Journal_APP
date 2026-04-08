package com.example.BasicToAdvance.qualifier;

import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Qualifier;

@Component
public class paymeSystem {

    private final paymentSErvice paymentSErvice;

    public paymeSystem(@Qualifier("bikash") paymentSErvice paymentSErvice) {
        this.paymentSErvice = paymentSErvice;
    }

    public void pay(){
        paymentSErvice.pay();
    }
}
