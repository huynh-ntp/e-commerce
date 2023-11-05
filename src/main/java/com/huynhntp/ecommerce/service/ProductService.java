package com.huynhntp.ecommerce.service;

import com.huynhntp.ecommerce.dto.ProductDto;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.multipart.MultipartFile;

public interface ProductService {

    ProductDto create(ProductDto dto, MultipartFile[] files, HttpServletRequest request);
}
