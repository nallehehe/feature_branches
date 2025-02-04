package com.example.feature_branches.repositories;

import com.example.feature_branches.models.Customers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customers, Long> {
 Customers findByEmail(String email);
}
