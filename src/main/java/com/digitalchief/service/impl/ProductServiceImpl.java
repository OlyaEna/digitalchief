package com.digitalchief.service.impl;

import com.digitalchief.model.dto.ProductDto;
import com.digitalchief.model.entity.Product;
import com.digitalchief.model.repository.ProductRepository;
import com.digitalchief.service.ProductService;
import com.digitalchief.service.mapper.ProductMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Override
    public List<ProductDto> findAll() {
        List<Product> products = productRepository.findAll();
        return productMapper.listToDto(products);
    }

    @Override
    public ProductDto findById(Long id) {
        return productMapper.toDto(productRepository.getReferenceById(id));
    }
}
