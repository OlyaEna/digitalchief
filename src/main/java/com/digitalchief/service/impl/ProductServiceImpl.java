package com.digitalchief.service.impl;

import com.digitalchief.exceptions.NonUniqueException;
import com.digitalchief.exceptions.NotFoundException;
import com.digitalchief.model.dto.GenreDto;
import com.digitalchief.model.dto.ProductDeleteDto;
import com.digitalchief.model.dto.ProductDto;
import com.digitalchief.model.entity.Product;
import com.digitalchief.model.repository.ProductRepository;
import com.digitalchief.model.repository.PublisherRepository;
import com.digitalchief.service.GenreService;
import com.digitalchief.service.ProductService;
import com.digitalchief.service.mapper.GenreMapper;
import com.digitalchief.service.mapper.ProductMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;
    private final PublisherRepository publisherRepository;
    private final GenreService genreService;
    private final GenreMapper genreMapper;

    @Override
    public List<ProductDto> findAll() {
        List<Product> products = productRepository.findAll();
        return productMapper.mapperToDtoList(products);
    }

    @Override
    public ProductDto save(ProductDto productDto) {
        return productMapper.mapperToDto(productRepository.save(productMapper.mapperToEntity(productDto)));

    }

    @Override
    public ProductDto create(ProductDto productDto) {
        ProductDto product = productMapper.toDto(productRepository.findByTitle(productDto.getTitle()));
        if (product == null) {
            return save(productDto);
        } else {
            throw new NonUniqueException("Product is incorrect or already exists. Try again.");
        }
    }

    @Transactional
    @Override
    public void deleteByName(String name) {
        ProductDto product = productMapper.toDto(productRepository.findByTitle(name));
        productRepository.delete(productMapper.toEntity(product));
    }


    @Override
    public ProductDto findByName(String name) {
        Product product = productRepository.findByTitle(name);
        if (product == null) {
            throw new NotFoundException("Product " + "'" + name + "'" + " does not exist. Try again.");
        }
        return productMapper.mapper(product);

    }

    @Override
    public ProductDto update(ProductDto productDto, String name) {
        Product product = productRepository.findByTitle(name);
        if (product != null) {
            product.setTitle(productDto.getTitle());
            product.setDescription(productDto.getDescription());
            product.setPublisher(publisherRepository.findByName(productDto.getPublisher()));
            product.setISBN(productDto.getISBN());
            product.setReleaseDate(productDto.getReleaseDate());
            productRepository.save(product);
        } else {
            throw new NotFoundException("Product " + "'" + name + "'" + " does not exist. Try again.");
        }
        return productMapper.mapper(product);
    }

    @Override
    public List<ProductDto> findProductsByGenre(String name) {
        GenreDto genreDto = genreService.findByName(name);
        List<Product> product= productRepository.findProductsByGenre(genreMapper.toEntity(genreDto));
        return productMapper.mapperToDtoList(product);
    }




}
