package com.msaclub.product.service;


import com.msaclub.product.domain.ProductEntity;
import com.msaclub.product.dto.ProductReqeustDto;
import com.msaclub.product.dto.StockRequestDto;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductService {
    List<ProductReqeustDto> getByProductName(String name, Pageable pageable, int categoryCode);

    Long InsertTest(ProductEntity entity);

    Long productCreate(ProductReqeustDto dto);

    Long productDelete(Long id);

    boolean stockCheck(Long productCode, int stock);

    Long productStockRemove(StockRequestDto dto);

    Long productEdit(ProductReqeustDto dto);

    boolean ProductCheck(Long productCode);

    ProductReqeustDto getByProductCode(Long productCode);
}
