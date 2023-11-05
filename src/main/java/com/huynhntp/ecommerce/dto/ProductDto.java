package com.huynhntp.ecommerce.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.util.List;

@Data
public class ProductDto {
    private String id;
    private String code;
    @NotEmpty(message = "Thiếu tên sản phẩm")
    private String name;
    private String mainImage;
    private List<String> secondaryImages;
    private String description;
}
