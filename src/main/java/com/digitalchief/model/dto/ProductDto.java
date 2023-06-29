package com.digitalchief.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.sql.Date;
import java.util.List;

@Getter
@Setter
@EqualsAndHashCode
public class ProductDto {
    @JsonIgnore
    private Long id;
    @NotEmpty
    @Size(min = 2, message = "product title should have at least 2 characters")
    private String title;
    @NotEmpty
    @Size(min = 10, message = "product description should have at least 10 characters")
    private String description;
    @Size(min = 10, message = "product ISBN should have at least 10 characters")
    private String ISBN;
    @JsonProperty("release_date")
    private Date releaseDate;
    private List<String> genres;
    @NotEmpty
    private String publisher;

    private List<String> authors;

}
