package com.digitalchief.service.mapper;

import com.digitalchief.model.dto.GenreDto;
import com.digitalchief.model.dto.ProductDto;
import com.digitalchief.model.entity.Genre;
import com.digitalchief.model.entity.Product;
import com.digitalchief.model.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

@Component
@AllArgsConstructor
public class ProductMapper {
    private ModelMapper modelMapper;

    public Product toEntity(ProductDto dto) {
        return Objects.isNull(dto) ? null : modelMapper.map(dto, Product.class);
    }

    public ProductDto toDto(Product entity) {
        return Objects.isNull(entity) ? null : modelMapper.map(entity, ProductDto.class);
    }

    public List<ProductDto> listToDto(List<Product> entity) {
        return Objects.isNull(entity) ? null : modelMapper.map(entity, new TypeToken<List<ProductDto>>() {
        }.getType());
    }
}
