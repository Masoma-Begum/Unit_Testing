package com.qa.login.model;

import java.util.ArrayList;
import java.util.List;

public class Cart {

    private List<Product> products = new ArrayList<>();

    public void addProduct(Product product) {
        products.add(product);
    }

    public int getItemCount() {
        return products.size();
    }

    public double getTotalAmount() {
        return products.stream()
                .mapToDouble(Product::getPrice)
                .sum();
    }
}
