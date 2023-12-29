package com.msaclub.product.service;

import com.msaclub.product.domain.CategoryEntity;
import com.msaclub.product.dto.CategoryDto;

import java.util.List;

public interface CategoryService {
    public int createCategory(CategoryDto category);

    public List<CategoryDto> ListCategory();
}
