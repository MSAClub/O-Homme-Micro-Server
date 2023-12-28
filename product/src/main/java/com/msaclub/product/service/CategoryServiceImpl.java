package com.msaclub.product.service;

import com.msaclub.product.domain.CategoryEntity;
import com.msaclub.product.dto.CategoryDto;
import com.msaclub.product.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;
    private final ModelMapper mapper;

    @Override
    @Transactional
    public int createCategory(CategoryDto category) {
        log.info("test : entity {}",category.getCategory_name());
        //setter Entity에 안쓰고하는 맵핑되게 하는 법
        mapper.getConfiguration().setFieldAccessLevel(org.modelmapper.config.Configuration.AccessLevel.PRIVATE).setFieldMatchingEnabled(true);
        CategoryEntity entity = mapper.map(category, CategoryEntity.class);
        log.info("test : entity {}",entity.getCategory_name());
        return categoryRepository.save(entity).getCategory_code();
    }

    @Override
    public List<CategoryDto> ListCategory() {
        return categoryRepository.findAll().stream().map(e -> mapper.map(e, CategoryDto.class))
                .collect(Collectors.toList());
    }


}
