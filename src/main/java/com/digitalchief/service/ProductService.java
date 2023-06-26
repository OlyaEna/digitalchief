package com.digitalchief.service;

import com.digitalchief.model.dto.ProductDto;

import java.util.List;

public interface ProductService {
    List<ProductDto> findAll();
    ProductDto findById(Long id);
}
