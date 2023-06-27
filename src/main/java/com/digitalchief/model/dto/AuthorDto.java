package com.digitalchief.model.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
public class AuthorDto {
    @JsonIgnore
    private Long id;
    private String name;
    @JsonProperty("birth_date")
    private Date birthDate;
    @JsonIgnore
    @JsonBackReference
    private List<ProductDto> products;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AuthorDto authorDto = (AuthorDto) o;
        return Objects.equals(id, authorDto.id) && Objects.equals(name, authorDto.name) && Objects.equals(birthDate, authorDto.birthDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, birthDate);
    }
}
