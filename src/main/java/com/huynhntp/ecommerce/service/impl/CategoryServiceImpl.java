package com.huynhntp.ecommerce.service.impl;

import com.huynhntp.ecommerce.dto.CategoryDto;
import com.huynhntp.ecommerce.entity.Category;
import com.huynhntp.ecommerce.mapper.MapperUtils;
import com.huynhntp.ecommerce.repository.CategoryRepository;
import com.huynhntp.ecommerce.service.CategoryService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    MapperUtils mapperUtils;
    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public CategoryDto create(CategoryDto dto, HttpServletRequest request) {
        Category category = mapperUtils.categoryToEntity(dto);
        if(dto.getParentId()!=null){
            Category parent = categoryRepository.findById(category.getParentId()).get();
            if(parent!=null){
                category.setParentId(parent.getId());
            }
        }
        return mapperUtils.categoryToDto(categoryRepository.save(category));
    }
}
