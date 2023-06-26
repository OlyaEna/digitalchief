package com.digitalchief.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PublisherDto {
    @JsonIgnore
    private Long id;
    private String name;
    private String address;
}
