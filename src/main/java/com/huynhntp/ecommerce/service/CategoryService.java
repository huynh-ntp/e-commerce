package com.huynhntp.ecommerce.service;

import com.huynhntp.ecommerce.dto.CategoryDto;
import jakarta.servlet.http.HttpServletRequest;

public interface CategoryService {
    CategoryDto create(CategoryDto dto, HttpServletRequest request);
}
