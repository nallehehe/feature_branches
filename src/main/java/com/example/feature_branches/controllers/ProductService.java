package com.example.feature_branches.controllers;


import com.example.feature_branches.models.Product;
import com.example.feature_branches.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("api/products")
public class ProductService {
   @Autowired
    private ProductRepository productRepository;

   @PostMapping
    public ResponseEntity <Product> createProduct (@RequestBody Product product){
       Product savedProduct = productRepository.save(product);
       return ResponseEntity.status(HttpStatus.CREATED).body(savedProduct);
   }

   @PutMapping
    public ResponseEntity <Product> updateProductById (@PathVariable Long productId, @RequestBody Product newProductDetails){
       Product exisitngProduct = productRepository.findById(productId)
               .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found"));
       return ResponseEntity.ok(exisitngProduct);
   }

   @GetMapping ResponseEntity <List<Product>>getAllProducts (){
       List <Product> allProducts = productRepository.findAll();
       return ResponseEntity.ok(allProducts);
   }


}
