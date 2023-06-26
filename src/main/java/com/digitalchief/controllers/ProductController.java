package com.digitalchief.controllers;

import com.digitalchief.model.dto.ProductDto;
import com.digitalchief.model.dto.SeriesDto;
import com.digitalchief.model.entity.Product;
import com.digitalchief.model.repository.ProductRepository;
import com.digitalchief.service.ProductService;
import com.digitalchief.service.SeriesService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
public class ProductController {
    private final ProductService productService;
    private final SeriesService seriesService;
    private final ProductRepository  productRepository;

    @GetMapping(path = "/all")
    public List<ProductDto> getAllProducts() {
        return productService.findAll();
    }



    @GetMapping(path = "/product/{id}")
    public ProductDto findProduct(@PathVariable Long id) {
        return productService.findById(id);
    }

    @GetMapping(path = "/series/{id}")
    public SeriesDto findSeries(@PathVariable Long id) {
        return seriesService.findById(id);
    }
}
