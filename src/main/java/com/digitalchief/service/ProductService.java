package com.digitalchief.service;

import com.digitalchief.model.dto.GenreDto;
import com.digitalchief.model.dto.ParamProductDto;
import com.digitalchief.model.dto.ProductDto;
import com.digitalchief.model.entity.Genre;
import com.digitalchief.model.entity.Product;

import java.util.List;

public interface ProductService {
    List<ProductDto> findAll();

    ProductDto save(ProductDto productDto);

    ProductDto create(ProductDto productDto);

    void deleteByName(String name);

    ProductDto findByName(String name);

    ProductDto update(ProductDto productDto, String name);

    List<ProductDto> findProductByGenre(GenreDto genre);
}
