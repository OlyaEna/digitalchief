package com.digitalchief.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDeleteDto {
    @JsonIgnore
    private Long id;
    private String title;
}
