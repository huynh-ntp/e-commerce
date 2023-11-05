package com.huynhntp.ecommerce.dto;

import lombok.Data;

@Data
public class CategoryDto {
    private String id;
    private String name;
    private String code;
    private Boolean isActive;
    private String parentId;
}
