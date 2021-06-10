package com.mercadolivre.DesafioQuality.responses;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class PropertyValueResponse {
    @JsonProperty(value = "prop_name")
    private String propName;
    @JsonProperty(value = "prop_district")
    private String propDistrict;
    @JsonProperty(value = "district_value")
    private Double districtValue;
    @JsonProperty(value = "prop_size")
    private Double propSize;
    @JsonProperty(value = "prop_value")
    private Double propValue;
}
