package com.example.feature_branches.repository;

import com.example.feature_branches.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
