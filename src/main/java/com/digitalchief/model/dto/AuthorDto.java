package com.digitalchief.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.sql.Date;


@Getter
@Setter
@EqualsAndHashCode
public class AuthorDto {
    @JsonIgnore
    private Long id;
    @NotEmpty
    @Size(min = 2, message = "author name should have at least 2 characters")
    private String name;
    @JsonProperty("birth_date")
    private Date birthDate;


}
