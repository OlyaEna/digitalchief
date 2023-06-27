package com.digitalchief.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthorProductDto {
    @JsonProperty("author_name")
    private String authorName;
    @JsonProperty("product_name")
    private String productName;
}
