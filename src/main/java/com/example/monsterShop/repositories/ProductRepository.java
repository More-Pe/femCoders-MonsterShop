package com.example.monsterShop.repositories;

import com.example.monsterShop.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
