package com.huynhntp.ecommerce.controller;

import com.huynhntp.ecommerce.dto.CategoryDto;
import com.huynhntp.ecommerce.entity.Category;
import com.huynhntp.ecommerce.service.CategoryService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategoryController {

    private final String root = "/api/v1/category";

    @Autowired
    private CategoryService categoryService;

    @PostMapping(value = {root})
    public ResponseEntity<?> create(@RequestBody()CategoryDto dto, HttpServletRequest request){
        return new ResponseEntity<>(categoryService.create(dto,request), HttpStatus.OK);
    }

}
