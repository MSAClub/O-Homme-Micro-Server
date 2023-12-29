package com.msaclub.product.repository;

import com.msaclub.product.domain.CategoryEntity;
import com.msaclub.product.domain.ProductEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
    Page<ProductEntity> findBySubjectContainingAndCategoryOrderByProductCodeDesc(String subject, Pageable pageable, CategoryEntity category);

    Page<ProductEntity> findBySubject(String subject, Pageable pageable);

    Optional<ProductEntity> findByProductCode(Long id);

    @Query("select p from ProductEntity p join fetch p.imageFiles i where p.productCode = :product_code order by i.file_order")
    Optional<ProductEntity> findWithImagesByProductCode(@Param("product_code") Long code);

}
