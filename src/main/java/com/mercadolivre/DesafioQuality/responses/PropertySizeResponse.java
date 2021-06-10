package com.mercadolivre.DesafioQuality.responses;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class PropertySizeResponse {
    @JsonProperty(value = "prop_name")
    private String propName;
    @JsonProperty(value = "prop_size")
    private Double propSize;
}
