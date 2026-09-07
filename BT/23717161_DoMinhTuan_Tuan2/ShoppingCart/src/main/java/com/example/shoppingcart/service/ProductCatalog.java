package com.example.shoppingcart.service;

import com.example.shoppingcart.model.Product;
import jakarta.enterprise.context.ApplicationScoped;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class ProductCatalog {
    private final List<Product> productList = List.of(
            new Product(1, "Iphone", new BigDecimal("10.000")),
            new Product(2, "SamSung", new BigDecimal("9.000")),
            new Product(3, "Nokia", new BigDecimal("8.000"))
    );

    public List<Product> findAll() {
        return productList;
    }

    public Optional<Product> findById(Long id) {
        return productList.stream().filter(product -> product.getId() == id).findFirst();
    }
}
