package com.msaclub.product.domain;

import com.msaclub.product.common.domain.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.DynamicInsert;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Table(name = "product")
@Getter
@ToString
@DynamicInsert
public class ProductEntity extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="product_code")
    private Long productCode;

    @Column
    private String seller;

    @Column
    private String subject;

    @Column
    private int price;

    @Column
    private int stock;

    @Column
    private String content;

    @Column
    private int hits;

    @Column
    private String thumbnail;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<ImageFileEntity> imageFiles = new ArrayList<>();

    @ManyToOne(optional = false)
    @JoinColumn(name = "category_id")
    private CategoryEntity category;


    public void addImageFile(ImageFileEntity entity) {
        this.imageFiles.add(entity);
        entity.setProduct(this);
    }


    @Builder
    public ProductEntity(String seller,String subject, int price, int stock, String content, String thumbnail, List<ImageFileEntity> imageFiles, CategoryEntity category) {
        this.seller = seller;
        this.subject = subject;
        this.price = price;
        this.stock = stock;
        this.content = content;
        this.thumbnail = thumbnail;
        this.imageFiles = imageFiles;
        this.category = category;
    }

    @Builder
    public void productStockRemove(int stock) {
        int left =this.getStock() - stock;
        if (left >= 0) this.stock = left;
    }

}
