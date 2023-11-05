package com.huynhntp.ecommerce.mapper;

import com.huynhntp.ecommerce.dto.CategoryDto;
import com.huynhntp.ecommerce.dto.ProductDto;
import com.huynhntp.ecommerce.entity.Category;
import com.huynhntp.ecommerce.entity.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MapperUtils {

    ProductDto productToDto(Product product);

    Product productToEntity(ProductDto productDto);

    CategoryDto categoryToDto(Category entity);

    Category categoryToEntity(CategoryDto dto);

}
