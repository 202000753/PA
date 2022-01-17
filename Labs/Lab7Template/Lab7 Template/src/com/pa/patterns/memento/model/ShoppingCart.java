package com.pa.patterns.memento.model;

import com.sun.org.apache.xml.internal.dtm.ref.DTMDefaultBaseIterators;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

public class ShoppingCart implements Originator{
    private List<Product> products;

    public ShoppingCart() {
        products = new ArrayList<>();
    }

    public void addProduct(Product p) {
        products.add(p);
    }

    public void reset() {
        products.clear();
    }

    public void removeProduct(Product p) {
        products.remove(p);
    }

    public Collection<Product> getProducts() {
        return products;
    }

    public double getTotal() {
        double total = 0;
        for (Product p : products) {
            total += p.getCost();
        }
        return total;
    }

    @Override
    public String toString() {
        return String.valueOf(products);
    }

    @Override
    public Memento createMemento() {
        Memento memento = new ShoppingCartMemento(this.products);
        return memento;
    }

    @Override
    public void setMemento(Memento savedState) {
        ShoppingCartMemento shoppingCartMemento = (ShoppingCartMemento) savedState;
        this.products = shoppingCartMemento.produtos;
    }

    private class ShoppingCartMemento implements Memento {
        List<Product> produtos;

        public ShoppingCartMemento(List<Product> produtos) {
            this.produtos = new ArrayList<>(produtos);
        }

        @Override
        public String getDescription() {
            String str = "Produtos:\n";
            for (Product p:produtos) {
                str += p.toString() + "\n";
            }

            return str;
        }
    }
}
