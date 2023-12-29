package com.msaclub.product.controller;

import com.msaclub.product.dto.CategoryDto;
import com.msaclub.product.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/category")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;

    @PostMapping("/create")
    public int create(CategoryDto dto) {
        return categoryService.createCategory(dto);
    }
    @GetMapping("/list")
    public List<CategoryDto> list(){
        return categoryService.ListCategory();
    }
}
