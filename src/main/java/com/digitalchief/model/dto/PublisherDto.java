package com.digitalchief.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@EqualsAndHashCode
@Getter
@Setter
public class PublisherDto {
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Long id;
    @JsonProperty(access = JsonProperty.Access.READ_WRITE)
    private String name;
    private String address;


}
