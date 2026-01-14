package com.qa.login.service;

import com.qa.login.model.Cart;
import com.qa.login.model.Product;

public class CartService {

    public void addProductToCart(Cart cart, Product product) {
        cart.addProduct(product);
    }
}
