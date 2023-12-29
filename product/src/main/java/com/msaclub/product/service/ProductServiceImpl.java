package com.msaclub.product.service;

import com.msaclub.product.domain.CategoryEntity;
import com.msaclub.product.domain.ImageFileEntity;
import com.msaclub.product.domain.ProductEntity;

import com.msaclub.product.dto.ProductReqeustDto;
import com.msaclub.product.dto.StockRequestDto;
import com.msaclub.product.repository.CategoryRepository;
import com.msaclub.product.repository.ImageFileRepository;
import com.msaclub.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;

import org.modelmapper.config.Configuration;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductServiceImpl implements ProductService {
    private final ModelMapper mapper;
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final ImageFileRepository imageFileRepository;


    @Override
    @Transactional(readOnly = true)
    public List<ProductReqeustDto> getByProductName(String name, Pageable pageable, int categoryCode) {
        System.out.println(name + " p" + pageable + " " + categoryCode);
        Optional<CategoryEntity> byId = categoryRepository.findById(categoryCode);
        if (byId.isPresent()) {
            PageRequest pageRequest = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), Sort.by("productCode").descending());
            Page<ProductEntity> products = productRepository.findBySubjectContainingAndCategoryOrderByProductCodeDesc(name, pageRequest, byId.get());
            return products.stream().map(data -> mapper.map(data,ProductReqeustDto.class)).collect(Collectors.toList());
        }
        return null;

    }

    @Override
    public Long InsertTest(ProductEntity entity) {
        return productRepository.save(entity).getProductCode();
    }

    @Override
    @Transactional
    public Long productCreate(ProductReqeustDto dto) {
        //로그인된 사용자인지 검증하는 로직이 들어가야함
        //그리고 판매자격이 있는 사람인지 검증

        //then
        log.info("info log dto={}",dto);
        mapper.getConfiguration().setFieldAccessLevel(Configuration.AccessLevel.PRIVATE).setFieldMatchingEnabled(true);

        ProductEntity map = mapper.map(dto, ProductEntity.class);
        ProductEntity productEntity = productRepository.save(map);
        System.out.println(productEntity);
        for (ImageFileEntity imageFileEntity : productEntity.getImageFiles()) {
            imageFileEntity.setProduct(productEntity);
            imageFileRepository.save(imageFileEntity);
        }
        log.info("info log map ={}",map);

        return productEntity.getProductCode();
    }

    @Override
    public Long productDelete(Long id) {
        //로그인된 사용자인지 검증하는 로직과 상품 등록한 사람과 이름이 같은지 확인해야함

        //then
        Optional<ProductEntity> byProductCode = productRepository.findByProductCode(id);
        if (byProductCode.isPresent()) {
            return byProductCode.get().getProductCode();
        }
        return null;
    }


    @Override
    public boolean stockCheck(Long productCode, int stock) {
        //productCode로 재고수량을 빼고 살수 있는지 없는지 boolean 형태로 반환
        Optional<ProductEntity> byProductCode = productRepository.findByProductCode(productCode);
        if (byProductCode.isPresent()) {
            return byProductCode.get().getStock() - stock >= 0 ? true : false;
        }
        return false;
    }

    @Override
    @Transactional
    public Long productStockRemove(StockRequestDto dto) {
        //결제가 되면 호출해서 제고를 제거해야함
        //이때 먼저 주문한 사용자 명을 가져올 수 있을 때만 빼야함 하지만 아직 없으니깐 넘어가

        //then
        if (stockCheck(dto.getProductCode(),dto.getStock())) {
            Optional<ProductEntity> byProductCode = productRepository.findByProductCode(dto.getProductCode());
            ProductEntity product = byProductCode.get();
            product.productStockRemove(dto.getStock());
            return productRepository.save(product).getProductCode();
        }
        return null;
    }

    @Override
    public Long productEdit(ProductReqeustDto dto) {
        //등록한 사용자가 동일한 지 확인하는 로직이 들어가야함

        //then
        Optional<ProductEntity> byProductCode = productRepository.findByProductCode(dto.getProductCode());
        if (byProductCode.isPresent()) {
            mapper.getConfiguration().setFieldAccessLevel(Configuration.AccessLevel.PRIVATE).setFieldMatchingEnabled(true);
            ProductEntity map = mapper.map(dto, ProductEntity.class);
            return productRepository.save(map).getProductCode();
        }
        return null;
    }

    @Override
    public boolean ProductCheck(Long productCode) {
        return productRepository.findByProductCode(productCode).isPresent();
    }

    @Override
    public ProductReqeustDto getByProductCode(Long productCode) {
        Optional<ProductEntity> byProductCode = productRepository.findWithImagesByProductCode(productCode);
        System.out.println(byProductCode);
        if(byProductCode.isPresent()){
            ProductReqeustDto map = mapper.map(byProductCode.get(), ProductReqeustDto.class);
            return map;
        }
        return null;
    }


}
