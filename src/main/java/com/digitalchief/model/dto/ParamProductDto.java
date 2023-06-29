package com.digitalchief.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ParamProductDto {
    @JsonProperty("param_name")
    @NotEmpty
    private String paramName;
    @JsonProperty("product_name")
    @NotEmpty
    private String productName;
}
