package com.example.feature_branches.controllers;

import com.example.feature_branches.models.Cart;
import com.example.feature_branches.repositories.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;

@RestController
@RequestMapping("/api/cart")
public class CartController {
    @Autowired
    CartRepository cartRepository;

    @GetMapping
    public List<Cart> getAllBooks() {
        return cartRepository.findAll();
    }

    @PostMapping
    public ResponseEntity <Cart> addBock(@RequestBody Cart cart){
        Cart savedcart = cartRepository.save(cart);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedcart);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cart> getSingleCart(@PathVariable Long id){
        return cartRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

}
