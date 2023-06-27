package com.digitalchief.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.sql.Date;


@Getter
@Setter
@EqualsAndHashCode
public class AuthorDto {
    @JsonIgnore
    private Long id;
    private String name;
    @JsonProperty("birth_date")
    private Date birthDate;


}
