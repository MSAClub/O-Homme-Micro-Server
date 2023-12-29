package com.msaclub.product.controller;

import com.msaclub.product.dto.ProductReqeustDto;
import com.msaclub.product.dto.StockRequestDto;
import com.msaclub.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;


    @GetMapping("/search/{subject}")
    public List<ProductReqeustDto> search(@PathVariable("subject") String subject
    , @PageableDefault(size = 20) Pageable pageable, @RequestParam("categoryCode") int  categoryCode) {

        return productService.getByProductName(subject, pageable,categoryCode);
    }

    @GetMapping("/detail/{productCode}")
    public ProductReqeustDto getDetailProduct(@PathVariable("productCode")  Long productCode){
        System.out.println(productCode);
        return productService.getByProductCode(productCode);
    }

    @PostMapping("/edit/{productCode}")
    public Long editProductCode(@PathVariable("productCode") Long productCode, @RequestBody ProductReqeustDto dto) {
        //검증 로직있어야함 유저 서비스한테서 해당 유저 판매자가 맞는지

        //then
        if(dto.getProductCode() == productCode){
            return productService.productEdit(dto);
        }
        return null;
    }
    @GetMapping("/stock/{productCode}/{stock}")
    public boolean stockCheck(@PathVariable("productCode")  Long productCode, @PathVariable("stock") int stock) {
        //구매 완료가 되었을 때 제고를 뺴야함
        System.out.println(productCode + " " + stock);
        return productService.stockCheck(productCode,stock);
    }


    @PostMapping("/stock/remove")
    public Long stockCheck(@RequestBody StockRequestDto dto) {
        //구매 완료가 되었을 때 제고를 뺴야함
        return productService.productStockRemove(dto);
    }

    @PostMapping("/regist")
    public Long productRegist(@RequestBody ProductReqeustDto dto) {
        return productService.productCreate(dto);
    }


}
