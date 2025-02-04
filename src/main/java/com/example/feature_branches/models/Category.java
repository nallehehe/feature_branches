package com.example.feature_branches.models;

import com.example.feature_branches.enum_category.Categories;
import jakarta.persistence.*;

@Entity
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /*ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;*/

    @Enumerated(EnumType.STRING)
    @Column(name = "category")
    private Categories categories;
}
