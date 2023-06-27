package com.digitalchief.model.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Objects;

@Getter
@Setter
public class GenreDto {
    @JsonIgnore
    private Long id;
    private String name;
    @JsonIgnore
    @JsonBackReference
    private List<ProductDto> products;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GenreDto genreDto = (GenreDto) o;
        return Objects.equals(id, genreDto.id) && Objects.equals(name, genreDto.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
