package com.digitalchief.model.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class GenreDto {
    @JsonIgnore
    private Long id;
    private String name;
    @JsonBackReference
    private List<ProductDto> products;
}
