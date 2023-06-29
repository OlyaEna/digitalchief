package com.digitalchief.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ParamProductDto {
    @JsonProperty("param_name")
    private String paramName;
    @JsonProperty("product_name")
    private String productName;
}
