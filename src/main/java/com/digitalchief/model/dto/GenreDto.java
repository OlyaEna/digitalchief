package com.digitalchief.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;


@Getter
@Setter
@EqualsAndHashCode
public class GenreDto {
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Long id;
    private String name;


}
