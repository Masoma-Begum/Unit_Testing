package com.qa.login.integration;

import com.qa.login.model.Cart;
import com.qa.login.model.Product;
import com.qa.login.service.CartService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CartIntegrationTest {

    @Test
    void addProductToCart_shouldWorkEndToEnd() {
        // Arrange
        Cart cart = new Cart();
        CartService cartService = new CartService();
        Product product = new Product("P01", "Mouse", 500.00);

        // Act
        cartService.addProductToCart(cart, product);

        // Assert
        assertEquals(1, cart.getItemCount());
        assertEquals(500.00, cart.getTotalAmount());
    }
}
