package com.huynhntp.ecommerce.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.huynhntp.ecommerce.dto.ProductDto;
import com.huynhntp.ecommerce.service.ProductService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController()
public class ProductController {

    private final String root = "/api/v1/product";

    @Autowired
    private ProductService productService;

    @PostMapping(value = {root})
    public ResponseEntity<?> create(@RequestParam(name = "product") String dataJson,
                                    @RequestParam(name = "files") MultipartFile [] files,
                                    HttpServletRequest request) {
        ObjectMapper objectMapper = new ObjectMapper();
        ProductDto dto = objectMapper.convertValue(dataJson,ProductDto.class);
        return new ResponseEntity<>(productService.create(dto,files,request), HttpStatus.OK);
    }


}
