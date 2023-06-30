package com.syqu.shop.service;

import com.syqu.shop.model.Product;
import com.syqu.shop.model.User;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public interface ShoppingCartService {
    void addProduct(Product product);
    void removeProduct(Product product);
    void clearProducts();
    Map<Product, Integer> productsInCart();

    BigDecimal totalPrice();
    void cartCheckout();
}
