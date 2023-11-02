package com.huynhntp.ecommerce.controller;

import com.huynhntp.ecommerce.entity.Product;
import com.huynhntp.ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController(value = "/api/v1/product")
public class ProductController {
    @Autowired
    private ProductService productService;

}
