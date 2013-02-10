package org.example.write.services;

import static java.lang.Math.random;

import org.springframework.stereotype.Component;

@Component
public class CatalogService {
    public double priceFor(String thing) {
        return random();
    }
}
