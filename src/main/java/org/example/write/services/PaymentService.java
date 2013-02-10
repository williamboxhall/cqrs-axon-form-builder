package org.example.write.services;

import org.springframework.stereotype.Component;

@Component
public class PaymentService {
    public void pay(double price) {
        System.out.println("paid $" + price);
    }
}
