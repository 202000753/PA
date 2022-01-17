package com.pa.patterns.observerimpl.model;

import com.pa.patterns.observerimpl.observer.Observer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ShoppingCartListView implements Observer {
    @Override
    public void update(Object obj) {
        if(obj instanceof ShoppingCart) {
            ShoppingCart cart = (ShoppingCart) obj;
            int count = 0;
            System.out.println("\n" + cart.getName() + "\n");
            List<Product> list = new ArrayList<>(cart.getProducts());
            Collections.sort(list);
            for (Product product:list)
                System.out.printf("%2d: %s - %.2f\n", count++, product.getName(), product.getCost());
        }
    }
}
