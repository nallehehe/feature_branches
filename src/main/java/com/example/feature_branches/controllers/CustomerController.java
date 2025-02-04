package com.example.feature_branches.controllers;

import com.example.feature_branches.models.Customers;
import com.example.feature_branches.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;
    @PostMapping
    public ResponseEntity<Customers> createCustomer(@RequestBody Customers customers) {
        Customers savedCustomers = customerRepository.save(customers);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedCustomers);

    }
    @GetMapping
   public List<Customers> getAllCustomers() {
        return customerRepository.findAll();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Customers> getCustomerById(@PathVariable Long id) {
        Optional<Customers> customer = customerRepository.findById(id);
        return customer.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());

        }
@PutMapping("/{id}")
    public ResponseEntity<Customers> updateCustomer(@PathVariable Long id, @RequestBody Customers customers) {
        Optional<Customers> customerOptional = customerRepository.findById(id);
        if (customerOptional.isPresent()) {
            customers.setId(id);
            customerRepository.save(customers);
            return ResponseEntity.ok(customers);

        }
        return ResponseEntity.notFound().build();

}
@DeleteMapping("/{id}")
    public ResponseEntity<Customers> deleteCustomer(@PathVariable Long id) {
        Optional<Customers> customer = customerRepository.findById(id);
        if (customer.isPresent()) {
            customerRepository.deleteById(id);
            return ResponseEntity.ok(customer.get());

        }
        return ResponseEntity.notFound().build();


}
    }


