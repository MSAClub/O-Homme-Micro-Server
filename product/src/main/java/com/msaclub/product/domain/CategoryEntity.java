package com.msaclub.product.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;


import java.util.List;

@Entity
@Table(name = "category")
@Getter
@NoArgsConstructor
public class CategoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="category_code")
    private int category_code;

    @Column
    private String category_name;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private List<ProductEntity> products;


    public CategoryEntity(String category_name) {
        this.category_name = category_name;
    }
}
