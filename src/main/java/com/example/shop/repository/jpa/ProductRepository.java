package com.example.shop.repository.jpa;

import com.example.shop.domain.jpa.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
