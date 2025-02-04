package com.example.feature_branches.repositories;

import com.example.feature_branches.models.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Long> {

}
