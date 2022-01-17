package com.pa.patterns.observerimpl.model;

import com.pa.patterns.observerimpl.observer.Observer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ShoppingCartAllert implements Observer {
    private double maxValue;

    public ShoppingCartAllert(double maxValue) {
        this.maxValue = maxValue;
    }

    @Override
    public void update(Object obj) {
        if(obj instanceof ShoppingCart) {
            ShoppingCart cart = (ShoppingCart) obj;
            Product lastAdded = cart.lastProductAdded();
            if(lastAdded.getCost() > maxValue) {
                System.out.println("ALLERT!!! - The product " + lastAdded.getName() + " (" + lastAdded.getCost() + ") has exceeded the maximum value configured " + maxValue +")");
            }
        }
    }
}
