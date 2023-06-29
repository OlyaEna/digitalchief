package com.digitalchief.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.*;


@Getter
@Setter
@EqualsAndHashCode
public class GenreDto {
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Long id;
    @NotEmpty
    @Size(min = 2, message = "genre name should have at least 2 characters")
    private String name;


}
