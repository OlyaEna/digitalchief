package com.digitalchief.service.impl;

import com.digitalchief.exceptions.NonUniqueException;
import com.digitalchief.exceptions.NotFoundException;
import com.digitalchief.model.dto.AuthorProductDto;
import com.digitalchief.model.dto.ProductDeleteDto;
import com.digitalchief.model.dto.ProductDto;
import com.digitalchief.model.entity.Author;
import com.digitalchief.model.entity.Genre;
import com.digitalchief.model.entity.Product;
import com.digitalchief.model.entity.Publisher;
import com.digitalchief.model.repository.AuthorRepository;
import com.digitalchief.model.repository.GenreRepository;
import com.digitalchief.model.repository.ProductRepository;
import com.digitalchief.model.repository.PublisherRepository;
import com.digitalchief.service.ProductService;
import com.digitalchief.service.mapper.ProductMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;
    private final AuthorRepository authorRepository;

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
        ProductDeleteDto product = productMapper.toDeleteDto(productRepository.findByTitle(name));
        productRepository.delete(productMapper.toDeleteEntity(product));
    }

    @Override
    public ProductDto findByName(String name) {
//        ProductDto product = productMapper.toDto(productRepository.findByTitle(name));
        Product product = productRepository.findByTitle(name);
        if (product == null) {
            throw new NotFoundException("Product " + "'" + name + "'" + " does not exist. Try again.");
        }
        return productMapper.mapper(product);

    }

    @Override
    public ProductDto update(ProductDto productDto, String name) {
        ProductDto product = findByName(name);
        if (product != null) {
            product.setTitle(productDto.getTitle());
            product.setDescription(productDto.getDescription());
            product.setPublisher(productDto.getPublisher());
            product.setISBN(productDto.getISBN());
            product.setReleaseDate(productDto.getReleaseDate());
//            product.setAuthors(productDto.getAuthors());
//            product.setGenre(productDto.getGenre());
            save(product);
        }
        return product;
    }


//    private List<Author> toAuthorList(List<String> strings) {
//        List<Author> authors = new ArrayList<>();
//        for (String string : strings) {
//            authors.add(authorRepository.findByName(string));
//        }
//        return authors;
//    }
//
//    private List<Genre> toGenreList(List<String> strings) {
//        List<Genre> genres = new ArrayList<>();
//        for (String string : strings) {
//            genres.add(genreRepository.findByName(string));
//        }
//        return genres;
//    }


    public void insertIntoAuthorProduct(AuthorProductDto authorProductDto) {
        if (authorProductDto != null) {
            Author author = authorRepository.findByName(authorProductDto.getAuthorName());
            Product product = productRepository.findByTitle(authorProductDto.getProductName());
            authorRepository.insertInto(author.getId(), product.getId());
        }
    }


}
