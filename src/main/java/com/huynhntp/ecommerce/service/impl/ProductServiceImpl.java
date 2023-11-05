package com.huynhntp.ecommerce.service.impl;

import com.huynhntp.ecommerce.dto.ProductDto;
import com.huynhntp.ecommerce.mapper.MapperUtils;
import com.huynhntp.ecommerce.repository.ProductRepository;
import com.huynhntp.ecommerce.service.ProductService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepo;
    @Autowired
    private MapperUtils mapperUtils;


    @Override
    public ProductDto create(ProductDto dto, MultipartFile[] files, HttpServletRequest request) {
        return null;
    }
}
