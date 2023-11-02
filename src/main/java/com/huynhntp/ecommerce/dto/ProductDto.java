package com.huynhntp.ecommerce.dto;

import lombok.Data;

@Data
public class ProductDto {
    private String id;
    private String code;
    private String name;
    private String imgUrl;
    private String description;
}
