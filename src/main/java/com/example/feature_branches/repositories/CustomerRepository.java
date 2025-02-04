package com.example.feature_branches.repositories;

import com.example.feature_branches.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
 Customer findByEmail(String email);
}
