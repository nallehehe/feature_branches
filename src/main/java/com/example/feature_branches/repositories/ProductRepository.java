package com.example.feature_branches.repositories;

import com.example.feature_branches.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository <Product, Long> {
}
