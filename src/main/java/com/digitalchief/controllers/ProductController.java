package com.digitalchief.controllers;

import com.digitalchief.model.dto.ProductDto;
import com.digitalchief.model.dto.SeriesDto;
import com.digitalchief.service.ProductService;
import com.digitalchief.service.SeriesService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/product")
public class ProductController {
    private final ProductService productService;
    private final SeriesService seriesService;

    @GetMapping(path = "/all")
    public List<ProductDto> getAllProducts() {
        return productService.findAll();
    }



    @GetMapping(path = "/{id}")
    public ProductDto findProduct(@PathVariable Long id) {
        return productService.findById(id);
    }

    @GetMapping(path = "/series/{id}")
    public SeriesDto findSeries(@PathVariable Long id) {
        return seriesService.findById(id);
    }
}
