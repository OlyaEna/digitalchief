package com.digitalchief.service.mapper;

import com.digitalchief.model.dto.ProductDto;
import com.digitalchief.model.entity.Author;
import com.digitalchief.model.entity.Genre;
import com.digitalchief.model.entity.Product;
import com.digitalchief.model.repository.PublisherRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
@AllArgsConstructor
public class ProductMapper {
    private ModelMapper modelMapper;
    private PublisherRepository publisherRepository;

    public ProductDto toDto(Product entity) {
        return Objects.isNull(entity) ? null : modelMapper.map(entity, ProductDto.class);
    }


    public Product toEntity(ProductDto dto) {
        return Objects.isNull(dto) ? null : modelMapper.map(dto, Product.class);
    }


    public ProductDto mapperToDto(Product product) {
        ProductDto productDto = new ProductDto();
        productDto.setId(product.getId());
        productDto.setTitle(product.getTitle());
        productDto.setDescription(product.getDescription());
        productDto.setISBN(product.getISBN());
        productDto.setReleaseDate(product.getReleaseDate());
        productDto.setPublisher(product.getPublisher().getName());
        return productDto;
    }

    public Product mapperToEntity(ProductDto productDto) {
        Product product = new Product();
        product.setTitle(productDto.getTitle());
        product.setDescription(productDto.getDescription());
        product.setISBN(productDto.getISBN());
        product.setPublisher(publisherRepository.findByName(productDto.getPublisher()));
        product.setReleaseDate(productDto.getReleaseDate());
        return product;
    }


    public List<ProductDto> mapperToDtoList(List<Product> products) {
        List<ProductDto> productDtoList = new ArrayList<>();
        for (Product product : products) {
            productDtoList.add(mapper(product));
        }
        return productDtoList;
    }


    private List<String> toStringAuthorList(List<Author> authors) {
        List<String> names = new ArrayList<>();
        for (Author author : authors) {
            names.add(author.getName());
        }
        return names;
    }

    private List<String> toStringGenreList(List<Genre> genres) {
        List<String> names = new ArrayList<>();
        for (Genre genre : genres) {
            names.add(genre.getName());
        }
        return names;
    }

    public ProductDto mapper(Product product) {
        ProductDto productDto =mapperToDto(product);
        productDto.setAuthors(toStringAuthorList(product.getAuthors()));
        productDto.setGenres(toStringGenreList(product.getGenre()));
        return productDto;
    }
}

