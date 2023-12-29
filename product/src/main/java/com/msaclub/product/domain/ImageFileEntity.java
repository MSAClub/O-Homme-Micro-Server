package com.msaclub.product.domain;


import jakarta.persistence.*;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Table(name ="imageFile")
public class ImageFileEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "file_code")
    private int fileCode;

    @ManyToOne
    @JoinColumn(name = "product_code")
    private ProductEntity product;

    @Column
    private String file_path;
    @Column
    private String file_order;

    public void setProduct(ProductEntity product) {
        this.product = product;
    }
}
