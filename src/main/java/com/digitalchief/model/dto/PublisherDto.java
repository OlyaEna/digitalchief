package com.digitalchief.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.*;

@EqualsAndHashCode
@Getter
@Setter
public class PublisherDto {
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Long id;
    @JsonProperty(access = JsonProperty.Access.READ_WRITE)
    @NotEmpty
    @Size(min = 2, message = "publisher name should have at least 2 characters")
    private String name;
    @NotEmpty
    @Size(min = 5, message = "publisher address should have at least 2 characters")
    private String address;


}
