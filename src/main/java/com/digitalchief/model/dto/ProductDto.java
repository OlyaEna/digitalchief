package com.digitalchief.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {
    @JsonIgnore
    private Long id;
    private String title;
    private String description;
    private String ISBN;
    @JsonProperty("release_date")
    private Date releaseDate;
    @JsonManagedReference
    private List<AuthorDto> authors;
    @JsonManagedReference
    private List<GenreDto> genre;
    private PublisherDto publisher;
    private SeriesDto series;
}
