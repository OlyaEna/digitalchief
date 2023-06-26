package com.digitalchief.model.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.util.List;

@Getter
@Setter
public class AuthorDto {
    @JsonIgnore
    private Long id;
    private String name;
    @JsonProperty("birth_date")
    private Date birthDate;
    @JsonBackReference
    private List<ProductDto> products;
}
